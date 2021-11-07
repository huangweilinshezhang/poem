new Vue({
  el: '#app',
  data () {
    // 验证邮箱的规则
    var checkEmail = (rule, value, callback) => {
      // 验证邮箱的正则表达式
      const regEmail = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/
      if (regEmail.test(value)) {
        // 合法邮箱
        return callback()
      }
      callback(new Error('请输入合法的邮箱'))
    }

    // 验证手机号的规则
    var checkMobile = (rule, value, callback) => {
      // 验证手机号的正则表达式
      const regMobile = /^1(3|4|5|6|7|8|9)\d{9}$/
      if (regMobile.test(value)) {
        // 合法邮箱
        return callback()
      }
      callback(new Error('请输入合法的手机号'))
    }

    return {
      // 获取用户列表的参数对象
      queryInfo: {
        query: '',
        pagenum: 1,
        pagesize: 10
      },
      userList: [{ "id": 1, "name": "1", "age": 1, "sex": "1", "number": "1", "email": "1", "address": "1", "staus": 0 }, { "id": 15, "name": "admin", "age": 15, "sex": "15", "number": "15", "email": "15", "address": "15", "staus": 0 }, { "id": 16, "name": "2", "age": 0, "sex": "2", "number": "2", "address": "2", "staus": 0 }, { "id": 17, "name": "11", "age": 1, "sex": "1", "number": "1", "email": "1", "address": "1", "staus": 0 }, { "id": 18, "name": "9", "age": 9, "sex": "9", "number": "9", "email": "9", "address": "9", "staus": 0 }, { "id": 19, "name": "9", "age": 9, "sex": "9", "number": "9", "email": "9", "address": "9", "staus": 0 }, { "id": 21, "name": "hwl", "age": 10, "sex": "?", "number": "10", "email": "10", "address": "10", "staus": 0 }, { "id": 23, "name": "hwl", "age": 10, "sex": "?", "number": "10", "email": "10", "address": "10", "staus": 0 }, { "id": 24, "name": "hwl", "age": 10, "sex": "?", "number": "10", "email": "10", "address": "10", "staus": 0 }, { "id": 27, "name": "w", "age": 2, "sex": "?", "number": "4", "email": "3", "address": "1", "staus": 0 }],
      total: 100,
      // 控制 添加 用户对话框的显示与隐藏
      addDialogVisible: false,
      // 添加用户的表单数据
      addForm: {},
      // 添加表单的验证规则对象
      addFormRules: {
        name: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          {
            min: 3,
            max: 10,
            message: '用户名的长度 3 ~ 10 个之间',
            trigger: 'blur'
          }
        ],
        pwd: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          {
            min: 6,
            max: 15,
            message: '密码的长度 6 ~ 15 个之间',
            trigger: 'blur'
          }
        ],
        email: [
          { required: true, message: '请输入邮箱', trigger: 'blur' },
          { validator: checkEmail, trigger: 'blur' }
        ],
        number: [
          { required: true, message: '请输入电话', trigger: 'blur' },
          { validator: checkMobile, trigger: 'blur' }
        ]
      },
      // 控制 修改 用户对话框的显示与隐藏
      editDialogVisible: false,
      // 查询到的用户信息对象
      editForm: {},
      // 修改表单的验证规则
      editFormRules: {
        email: [
          { required: true, message: '请输入用户的邮箱', trigger: 'blur' },
          {
            validator: checkEmail,
            message: '请输入正确的邮箱地址',
            trigger: 'blur'
          }
        ],
        number: [
          { required: true, message: '请输入用户的手机号', trigger: 'blur' },
          {
            validator: checkMobile,
            message: '请输入正确的手机号',
            trigger: 'blur'
          }
        ]
      }
    }
  },
  created () {
    this.getUserList()
  },
  methods: {
    async getUserList () {
      const { data: res } = await axios.get('/javaweb/selectAllUser.mvc', {
        params: {
          page: this.queryInfo.pagenum,
          count: this.queryInfo.pagesize
        }
      })
      console.log('获取到的数据')
      console.log(res)
      if (res[0].total) {
        this.total = res[0].total
      }
      this.userList = res
      console.log('现在的数据')
      console.log(this.userList)
    },
    // 监听 pagesize 改变
    handleSizeChange (newSize) {
      this.queryInfo.pagesize = newSize
      this.getUserList()
    },
    // 监听 页码值 改变的事件
    handleCurrentChange (newPage) {
      this.queryInfo.pagenum = newPage
      this.getUserList()
    },
    // 监听 switch 开关状态的改变
    async userStateChanged (userInfo) {
      alert('暂无实现')
    },
    // 监听 添加用户对话框 的关闭事件
    addDialogClosed () {
      this.$refs.addFormRef.resetFields()
    },
    // 点击按钮 添加新用户
    addUser () {
      this.$refs.addFormRef.validate(async valid => {
        if (!valid) return false
        const { data: res } = await axios.get('/javaweb/reg.mvc', {
          params: this.addForm
        })
        // 添加成功
        if (res != '200') {
          alert('添加失败')
        }
        alert('添加成功')
        // 隐藏添加用户的对话框
        this.addDialogVisible = false
        // 清楚数据
        this.$refs.addFormRef.resetFields()
      })
    },
    // 点击 展示编辑用户的对话框
    async showEditDialog (id) {
      const { data: res } = await axios.get('/javaweb/select.mvc?id=' + id)
      console.log("修改时查询到的数据")
      console.log(res)
      this.editForm = res[0]
      console.log(this.editForm)
      this.editDialogVisible = true
    },
    // 监听 修改用户对话框的 关闭事件
    editDialogClosed () {
      this.$refs.editFormRef.resetFields()
    },
    // 点击按钮 修改用户信息
    editUserInfo () {
      this.$refs.editFormRef.validate(async valid => {
        if (!valid) return false
        const { data: res } = await axios.get('/javaweb/update.mvc', {
          params: this.editForm
        })
        if (res != '200') {
          alert('修改失败')
        }
        alert('修改成功')
        // 关闭对话框
        this.editDialogVisible = false
        // 刷新数据列表
        this.getUserList()
      })
    },
    // 根据id删除对应的用户信息
    async removeUserById (id) {
      const result = await confirm('该删除操作无法返回，是否确定？')
      if (!result) return
      const { data: res } = await axios.get('/javaweb/delete.mvc?id=' + id)
      if (res != '200') {
        alert('删除失败')
      }
      alert('删除成功')
      // 刷新数据列表
      this.getUserList()
    }
  }
})
