new Vue({
  el: '#app',
  data () {
    return {
      // 添加作者对话框
      addDialogVisible: false,
      editDialogVisible: false,
      typeList: [],
      poetList: [{
        poet: '123'
      }],
      searchForm: {
        dynasty: '',
        poet: ''
      },
      // 防抖
      timer: null,
      addForm: {
        title: '',
        poet: '',
        dynasty: '',
        content: ''
      },
      addFormRules: {
        name: [{ required: true, message: '请输入作者名', trigger: 'blur' }],
        chaodai: [{ required: true, message: '请输入朝代', trigger: 'blur' }],
        msg: [{ required: true, message: '请输入古诗内容', trigger: 'blur' }]
      },
      editForm: {
        title: '',
        poet: '',
        dynasty: '',
        content: ''
      },
      editFormRules: {
        name: [{ required: true, message: '请输入作者名', trigger: 'blur' }],
        chaodai: [{ required: true, message: '请输入朝代', trigger: 'blur' }],
        msg: [{ required: true, message: '请输入古诗内容', trigger: 'blur' }]
      },
      // 分页数据
      page: 1,
      num: 10,
      total: 200,
      staus: Number(window.sessionStorage.getItem('staus'))
    }
  },
  created () {
    this.getPoetList()
    console.log('staus:', this.staus)
  },
  methods: {
    // 获取信息
    getPoetList () {
      // 防抖动，等不动了发送最后一次请求
      if (this.timer) {
        clearTimeout(this.timer)
        this.timer = setTimeout(async () => {
          // 发送请求
          const { data: res } = await axios.get('/javaweb/ctrl/selectAllAuther.mvc', {
            params: {
              page: this.page,
              count: this.num,
              dynasty: this.searchForm.chaodai,
              poet: this.searchForm.zuozhe
            }
          })
          this.total = res[0].total
          this.poetList = res
        }, 100)
      } else {
        this.timer = setTimeout(async () => {
          // 发送请求
          const { data: res } = await axios.get('/javaweb/ctrl/selectAllAuther.mvc', {
            params: {
              page: this.page,
              count: this.num,
              dynasty: this.searchForm.chaodai,
              poet: this.searchForm.zuozhe
            }
          })
          this.total = res[0].total
          this.poetList = res
        }, 100)
      }
      console.log(this.poetList)
    },
    // 添加对话框关闭事件
    addDialogClose () {
      this.$refs.addFormRef.resetFields()
    },
    // 添加
    add () {
      this.$refs.addFormRef.validate(async valid => {
        console.log(this.addForm)
        if (!valid) return
        const { data: res } = await axios.get('/javaweb/ctrl/addtwoPoet.mvc', {
          params: {
            auther: this.addForm.poet,
            msg: this.addForm.msg,
          }
        })
        if (res.status === 400) return alert('添加失败')
        this.getPoetList()
        this.addDialogVisible = false
        this.$refs.addFormRef.resetFields()
        alert('添加成功')
      })
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
    // 编辑
    edit () {
      console.log(this.editForm)
      this.$refs.editFormRef.validate(async valid => {
        if (!valid) return
        const { data: res } = await axios.get('/javaweb/ctrl/updatePoet.mvc', {
          params: {
            id: this.editForm.id,
            auther: this.editForm.poet,
            msg: this.editForm.msg,
          }
        })
        if (res.status === 400) return alert('修改失败')
        this.getPoetList()
        this.editDialogVisible = false
        this.$refs.editFormRef.resetFields()
        alert('修改成功')
      })
    },
    // 删除
    async remove (poet) {
      console.log(poet)
      var confirmResult = confirm("此操作无法撤回，是否确定删除？");
      if (confirmResult == true) {
        const { data: res } = await axios.get('/javaweb/ctrl/deletePoet.mvc', {
          params: {
            auther: poet
          }
        })
        if (res.data === 400) return alert('删除失败')
        this.getPoetList()
        alert('删除成功')
      }
      else {
        alert('已经取消删除')
      }
    },
    handleSizeChange (size) {
      this.num = size
      this.getPoetList()
    },
    handleCurrentChange (page) {
      this.page = page
      this.getPoetList()
    }
  }
})