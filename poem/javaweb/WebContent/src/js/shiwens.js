const vue = new Vue({
  el: '#app',
  data () {
    return {
      // 添加古诗对话框
      addDialogVisible: false,
      editDialogVisible: false,
      typeList: [{ type: '冲冲冲' }],
      poetList: [{ poet: '冲冲冲' }],
      dynastyList: [{ dynasty: '冲冲冲' }],
      poemList: [],
      // 分页数据
      page: 1,
      num: 10,
      total: 200,
      type: '',
      poet: '',
      dynasty: '',
      addForm: {
        title: '',
        poet: '',
        dynasty: '',
        content: ''
      },
      addFormRules: {
        title: [{ required: true, message: '请输入古诗名', trigger: 'blur' }],
        poet: [{ required: true, message: '请输入作者', trigger: 'blur' }],
        dynasty: [{ required: true, message: '请输入朝代', trigger: 'blur' }],
        content: [{ required: true, message: '请输入古诗内容', trigger: 'blur' }]
      },
      editForm: {
        title: '',
        poet: '',
        dynasty: '',
        content: ''
      },
      editFormRules: {
        title: [{ required: true, message: '请输入古诗名', trigger: 'blur' }],
        poet: [{ required: true, message: '请输入作者', trigger: 'blur' }],
        dynasty: [{ required: true, message: '请输入朝代', trigger: 'blur' }],
        content: [{ required: true, message: '请输入古诗内容', trigger: 'blur' }]
      },
      staus: Number(window.sessionStorage.getItem('staus'))
    }
  },
  created () {
    this.getEvery()
    console.log('staus:',this.staus)
  },
  methods: {
    getEvery () {
      this.getpoemList()
      this.getTypeList()
      this.getPoetList()
      this.getDynastyList()
    },
    // 获取所有古诗
    async getpoemList () {
      const { data: res } = await axios.get('/javaweb/ctrl/selectAllPoem.mvc', {
        params: {
          page:this.page,
          count: this.num,
          poet:this.poet,
          dynasty:this.dynasty,
          type:this.type
        }
      })
      this.total = res[0].total
      this.poemList = res
    },
    // 获取所有类型
    async getTypeList () {
      const { data: res } = await axios.get('/javaweb/ctrl/selectAllType.mvc?page=&count=')
      this.typeList = res
    },
    // 获取所有作者
    async getPoetList () {
      const { data: res } = await axios.get('/javaweb/ctrl/selectAllAuther.mvc?page=&count=')
      this.poetList = res
    },
    // 获取所有朝代
    async getDynastyList () {
      const { data: res } = await axios.get('/javaweb/ctrl/selectAllDynasty.mvc?page=&count=')
      this.dynastyList = res
    },
    handleSizeChange (size) {
      this.num = size
      this.getpoemList()
    },
    handleCurrentChange (page) {
      this.page = page
      this.getpoemList()
    },
    // 超出部分的显示与隐藏
    isShow (e) {
      if (Array.from(e.target.classList).includes('el-icon-bottom')) {
        e.target.classList.remove('el-icon-bottom')
        e.target.classList.add('el-icon-top')
        e.target.parentElement.parentElement.style.height = 'auto'
      } else {
        e.target.classList.remove('el-icon-top')
        e.target.classList.add('el-icon-bottom')
        e.target.parentElement.parentElement.style.height = '25px'
      }
    },
    // 添加对话框关闭事件
    addDialogClose () {
      this.$refs.addFormRef.resetFields()
    },
    deepClone (obj) {
      if (typeof obj !== 'object') return obj
      const result = Array.isArray(obj) ? [] : {}
      for (let key in obj) {
        if (typeof obj[key] === 'object') {
          result[key] = this.deepClone(obj[key])
        } else {
          result[key] = obj[key]
        }
      }
      return result
    },
    // 编辑对话框
    showEditDialog (info) {
      this.editForm = this.deepClone(info)
      this.editDialogVisible = true
    },
    // 编辑对话框关闭事件
    editDialogClose () {
      this.$refs.editFormRef.resetFields()
    },
    add () {
      this.$refs.addFormRef.validate(async valid => {
        console.log(this.addForm)
        if (!valid) return
        const { data: res } = await axios.get('/javaweb/ctrl/addPoem.mvc', {
          params: {
            title: this.addForm.title,
            dynasty: this.addForm.dynasty,
            auther: this.addForm.poet,
            content: this.addForm.content,
            type: this.addForm.type,
          }
        })
        if (res.status === 400) return alert('添加失败')
        this.getEvery()
        this.addDialogVisible = false
        this.$refs.addFormRef.resetFields()
        alert('添加成功')
      })
    },
    edit () {
      this.$refs.editFormRef.validate(async valid => {
        if (!valid) return
        const { data: res } = await axios.get('/javaweb/ctrl/updatePoem.mvc', {
          params: {
            id: this.editForm.id,
            title: this.editForm.title,
            dynasty: this.editForm.dynasty,
            auther: this.editForm.poet,
            content: this.editForm.content,
            type: this.editForm.type,
          }
        })
        if (res.status === 400) return alert('修改失败')
        this.getEvery()
        this.editDialogVisible = false
        this.$refs.editFormRef.resetFields()
        alert('修改成功')
      })
    },
    // 删除
    async remove (id) {
      var confirmResult = confirm("此操作无法撤回，是否确定删除？");
      if (confirmResult == true) {
        const { data: res } = await axios.get('/javaweb/ctrl/deletePoem.mvc', {
          params: {
            id
          }
        })
        if (res.data === 400) return alert('删除失败')
        this.getEvery()
        alert('删除成功')
      }
      else {
        alert('已经取消删除')
      }
    }
  },
  watch: {
    type (newVal, oldVal) {
      this.getpoemList()
    },
    poet (newVal, oldVal) {
      this.getpoemList()
    },
    dynasty (newVal, oldVal) {
      this.getpoemList()
    }
  }
})