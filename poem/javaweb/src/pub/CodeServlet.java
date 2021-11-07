package pub;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/code")
public class CodeServlet extends HttpServlet{
	private int count=0;
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("CodeServiet.init()");
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			  throws ServletException, IOException {
		count++;
		System.out.println("验证码的功能被调用了:"+count+"次");
		//1.随机生成验证码
		String[] chars= {"+","—","*"};
		Random rdm=new Random(System.currentTimeMillis());
//		int num=rdm.nextInt(10);String code=num+"";
//		String code=chars[rdm.nextInt(chars.length)]
//				   +chars[rdm.nextInt(chars.length)];
		int a=rdm.nextInt(10),b=rdm.nextInt(10);
		int op=rdm.nextInt(chars.length);
		String code=a+chars[op]+b+"=";
		int result=0;
		switch(op) {
		case 0:result=a+b;break;case 1:result=a-b;break;
		case 2:result=a*b;
		}
		HttpSession session=req.getSession();
		session.setAttribute("trueAnswer", result+"");//利用会话保存验证码答案
		//2.把验证码转换成图片
		int w=200,h=100;
		BufferedImage img=new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
		Color bgColor=new Color(0xDCDCDC);
		Graphics2D g=img.createGraphics();
		g.setColor(bgColor);
		g.fillRect(0, 0, w, h);
		g.setColor(Color.BLACK);
		Font font=new Font(null,Font.BOLD,60);
		g.setFont(font);
		g.drawString(code, w/2-50, h/2+25);
		//3.增加干扰素
		g.setColor(Color.RED);
		for(int line=1;line<=3;line++) {
			int[] x=new int[4];int[] y=new int[4];
			for(int p=0;p<4;p++) {
				x[p]=rdm.nextInt(w);y[p]=rdm.nextInt(h);
			}
			g.drawPolyline(x, y, x.length);
		}
		//4.图片发送给客户端
		resp.setContentType("image/jpeg");
		ImageIO.write(img,"jpg",resp.getOutputStream());
	}
}
