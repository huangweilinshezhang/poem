new Vue({
  el: '#app',
  data () {
    return {
      typeList: [{type:'好兄好兄弟'}],
      poetList: [],
      dynastyList: [],
      poemList: [],
      // 分页数据
      page: 1,
      num: 10,
      total: 200,
      type: '',
      poet: '',
      dynasty: ''
    }
  },
  methods: {
    // 获取所有古诗
    async getpoemList () {
      const { data: res } = await axios.get('/javaweb/ctrl/selectAllPoem.mvc', {
        params: {
          page: this.page,
          count: this.num,
          poet: this.poet,
          dynasty: this.dynasty,
          type: this.type
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
    }
  },
  created () {
    this.getpoemList()
    this.getTypeList()
    this.getPoetList()
    this.getDynastyList()
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
