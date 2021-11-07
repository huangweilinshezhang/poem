let codeVal = ''
// 生成随机数
randomNumber = (min, max) => {
  return Math.floor(Math.random() * (max - min + 1) + min)
}
// 生成随机颜色
randomColor = (min, max) => {
  const r = randomNumber(min, max)
  const g = randomNumber(min, max)
  const b = randomNumber(min, max)
  return `rgb(${r},${g},${b})`
}
// 绘制文本
drawText = (ctx, value, i) => {
  ctx.font = randomNumber(16, 20) + 'px Arial'
  ctx.fillStyle = randomColor(0, 150)
  // 获取ctx的长度
  const width = ctx.canvas.offsetWidth
  const height = ctx.canvas.offsetHeight
  const widthOne = width / 5
  const x = (i + 1) * widthOne - widthOne / 2
  const y = this.randomNumber(20, height - 12)
  const deg = this.randomNumber(-45, 45)
  ctx.translate(x, y)
  ctx.rotate(deg * Math.PI / 180)
  ctx.fillText(value, 0, 0)

  ctx.rotate(-deg * Math.PI / 180)
  ctx.translate(-x, -y)
}
// 随机生成验证码
randomCanvas = (ctx) => {
  // 绘画背景色
  ctx.fillStyle = this.randomColor(160, 255)
  // 填充图案
  const width = ctx.canvas.offsetWidth
  const height = ctx.canvas.offsetHeight
  ctx.fillRect(0, 0, width, height)
  // 绘画文本
  let value = ''
  for (let i = 0; i < 4; i++) {
    const num = randomNumber(0, 9)
    value += num
    this.drawText(ctx, num, i)
  }
  return value
}


// 注册功能
register = () => {
  const code = document.querySelector('#code')
  const xieyi = document.querySelector('#xieyi')
  if (!xieyi.checked) {
    alert('请确认用户协议')
    return false
  }
  if (codeVal !== code.value) {
    alert('请输入正确的验证码')
    return false
  }
  if (codeVal !== code.value) {
    alert('请输入正确的验证码')
    return false
  }

  const xhr = new XMLHttpRequest()
  xhr.onreadystatechange = function () {
    if (xhr.readyState === 4 && xhr.status === 200) {
      console.log(xhr.responseText)
      var json = JSON.parse(xhr.responseText)
      window.sessionStorage.setItem('staus', Number(json.staus))
      window.location.href = './index.html'
    }
  }

  const url = '/javaweb/reg.mvc'
  const username = document.querySelector('#username').value
  const password = document.querySelector('#password').value


  xhr.open('post', url)
  xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded")
  xhr.send(`name=${encodeURI(encodeURI(username))}&pwd=${encodeURI(encodeURI(password))}`)
}

window.onload = function () {
  if (window.sessionStorage.getItem('staus')) {
    alter('已经登录')
    window.location.href = './index.html'
  }
  const ul = document.querySelector('.navList')
  ul.onclick = function (e) {
    const activeLi = ul.querySelector('.active')
    activeLi.classList.remove('active')
    e.target.parentElement.classList.add('active')
  }


  const canvas = document.querySelector('.canvas')
  const ctx = canvas.getContext('2d')
  codeVal = randomCanvas(ctx)
  // 验证码
  canvas.onclick = function () {
    codeVal = ''
    codeVal = randomCanvas(ctx)
  }
}