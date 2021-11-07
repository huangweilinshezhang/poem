new Vue({
  el: '#app',
  data () {
    return {
      //游戏名字
      name: 'sctk',
      // 搜索表单数据
      searchForm: {},
      // 类型数据
      leixing: [{
        value: 1,
        label: '诗经'
      }, {
        value: 2,
        label: '乐府'
      }, {
        value: 3,
        label: '送别'
      }],
      // 作者数据
      zuozhe: [{
        value: 1,
        label: '诗经'
      }, {
        value: 2,
        label: '乐府'
      }, {
        value: 3,
        label: '送别'
      }],
      // 朝代数据
      chaodai: [{
        value: 1,
        label: '诗经'
      }, {
        value: 2,
        label: '乐府'
      }, {
        value: 3,
        label: '送别'
      }],
      // 诗词填空的字符串
      sctkObj: {
        title: '西湖杂咏·夏',
        zuozhe: '薛昂夫',
        chaodai: '元代',
        msg: '晴云轻漾，熏风无浪，开樽避暑争相向。'
      },
      sctkStr: '',
      sctkArr: [],
      // 诗词填空的答案
      sctkValue: '',
      yszcObj: {
        title: '西湖杂咏·夏',
        zuozhe: '薛昂夫',
        chaodai: '元代',
        msg: '晴云轻漾',
        msgArr: ['熏风无浪', '开樽避暑争相向'],
        true: '熏风无浪',
        flag: true
      },
      showKey: false,
      showFlag: true
    }
  },
  created () {
    this.sctk()
    this.yszc()
    this.getTypeList()
    this.getPoetList()
    this.getDynastyList()
  },
  methods: {
    selectHandleChange () {
      if (this.name == 'sctk') {
        this.sctk()
      } else if (this.name == 'yszc') {
        this.yszc()
      }
    },
    // 获取所有类型
    async getTypeList () {
      const { data: res } = await axios.get('/javaweb/ctrl/selectAllType.mvc?page=&count=')
      this.leixing = res
    },
    // 获取所有作者
    async getPoetList () {
      const { data: res } = await axios.get('/javaweb/ctrl/selectAllAuther.mvc?page=&count=')
      this.zuozhe = res
    },
    // 获取所有朝代
    async getDynastyList () {
      const { data: res } = await axios.get('/javaweb/ctrl/selectAllDynasty.mvc?page=&count=')
      this.chaodai = res
    },
    async yszc () {
      const { data: res } = await axios.get('/javaweb/ctrl/game1.mvc', {
        params: {
          type: this.searchForm.leixing,
          poet: this.searchForm.zuozhe,
          dynasty: this.searchForm.chaodai
        }
      })
      this.yszcObj = {
        title: res.title,
        zuozhe: res.poet,
        chaodai: res.dynater,
        msg: res.suggestiveVerse,
        msgArr: res.choose,
        true: res.trueAnswer,
        flag: !res.flag
      }
    },
    // 符号转换
    toChar (str) {
      str = str.replace(/\,/g, '，')
      str = str.replace(/\;/g, '；')
      str = str.replace(/\:/g, '：')
      str = str.replace(/\!/g, '！')
      str = str.replace(/\?/g, '？')
      str = str.replace(/\./g, '。')
      return str
    },
    // 随机数
    randomNumber (min, max) {
      return Math.floor(Math.random() * (max - min + 1) + min)
    },
    //拆散句子为空
    async sctk () {
      // 拿到诗词
      const { data: res } = await axios.get('/javaweb/ctrl/game2.mvc', {
        params: {
          type: this.searchForm.leixing,
          poet: this.searchForm.zuozhe,
          dynasty: this.searchForm.chaodai
        }
      })
      this.sctkObj = {
        title: res[0].title,
        zuozhe: res[0].poet,
        chaodai: res[0].dynasty,
        msg: res[0].content
      }
      let str = res[0].content
      // 将诗词符号转为中文
      str = this.toChar(str)
      let strArr = str.split('，')
      // 随机拿出一段
      this.sctkStr = strArr[this.randomNumber(0, strArr.length - 1)]
      let flag = false
      let subStrArr = ''
      if (/\。/.exec(this.sctkStr)) {
        subStrArr = this.sctkStr.split('。')
        flag = true
      } else if (/\；/.exec(this.sctkStr)) {
        subStrArr = this.sctkStr.split('；')
        flag = true
      } else if (/\！/.exec(this.sctkStr)) {
        subStrArr = this.sctkStr.split('！')
        flag = true
      } else if (/\？/.exec(this.sctkStr)) {
        subStrArr = this.sctkStr.split('？')
        flag = true
      }
      if (!subStrArr[subStrArr.length - 1]) flag = false
      if (flag) {
        this.sctkStr = subStrArr[this.randomNumber(0, subStrArr.length - 1)]
      }
      this.sctkArr = str.split(this.sctkStr)
      console.log(this.sctkStr)
      console.log(this.sctkStr.length)
      document.querySelector('.sctkInput').style.width = (this.sctkStr.length * 25) + 'px'
    },
    handleOptionClick (e) {
      if (this.showKey) return
      e.target.style.border = '1px solid rgb(220, 156, 86)'
      const value = e.target.innerText
      if (this.yszcObj.true === value) {
        this.showFlag = true
        const mask = document.querySelector('.yes').querySelector('.mask')
        mask.style.animationName = "moveRight"
      } else {
        this.showFlag = false
        const maskList = document.querySelector('.no').querySelectorAll(".mask")
        console.log(maskList)
        maskList[0].style.animationName = "moveLeft"
        maskList[1].style.animationName = "moveRight"
      }
      this.showKey = true
    },
    sctkClick () {
      if (this.sctkValue === this.sctkStr) {
        alert('填写成功')
      } else {
        alert('填写错误，正确答案是：' + this.sctkStr)
      }
      this.sctk()
    },
    nextYSZC () {
      console.log('下一题')
      this.showKey = false
      let div = document.querySelectorAll('.select_box')
      for (let i = 0; i < div.length; i++) {
        console.log(div[i])
        div[i].querySelector('span').style.border = 'none'
      }
      const mask = document.querySelector('.yes').querySelector('.mask')
      if (mask) {
        mask.style.animationName = ""
      }
      const maskList = document.querySelector('.no').querySelectorAll(".mask")
      if (maskList) {
        maskList[0].style.animationName = ""
        maskList[1].style.animationName = ""
      }
      this.yszc()
    }
  },
  computed: {
    titleName () {
      let name = ''
      switch (this.name) {
        case 'sctk':
          name = '诗词填空'
          break;
        case 'yszc':
          name = '吟诗作词'
          break;
      }
      return name
    },
    yszcKey () {
      return this.yszcObj.flag ? '下一句' : '上一句'
    }
  }
})