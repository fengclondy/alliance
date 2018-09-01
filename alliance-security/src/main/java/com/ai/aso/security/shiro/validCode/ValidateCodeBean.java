package com.ai.aso.security.shiro.validCode;

import com.ai.aso.base.utils.StringUtil;

import javax.imageio.ImageIO;
import javax.inject.Named;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Random;

import static java.awt.BasicStroke.CAP_BUTT;
import static java.awt.BasicStroke.JOIN_BEVEL;
import static java.awt.image.BufferedImage.TYPE_INT_RGB;

/**
 * 自定义验证码
 * 
 * @author John
 */
@Named
@SuppressWarnings("serial")
public class ValidateCodeBean implements Serializable {
	public static final String VALIDCODE = "validCode";// 保存到session中的键
	public static final String IMAGETYPE = "jpg";// 图片类型
	public static final String CONTENTTYPE = "image/jpeg";
	private int width = 80;// 图片宽度
	private int height = 40;// 图片高度
	private int length = 4;// 验证码长度
	private int fontStyle = Font.PLAIN;// 字体样式
	private String fonts = "Arial,Courier,Tahoma";// 字体
	private String words = "abcdefghkmnpqrstuvwxyz123456789ABCDEFGHKLMNPQRSTUVWXYZ";// 字符内容
//	private String words = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";// 字符内容
	
	private String number = "0123456789";
	private String lowerCase = "abcdefghijklmnopqrstuvwxyz";
	private String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static final int NUMBER = 1;
	public static final int LOWERCASE = 10;
	public static final int UPPERCASE = 100;
	public static final int NUMBER_LOWERCASE = 11;
	public static final int NUMBER_UPPERCASE = 101;
	public static final int LOWER_UPPER_CASE = 110;
	public static final int MIX_ALL = 111;

	public ValidateCodeBean(){
		
	}
	
	public ValidateCodeBean(int length, int mixStyle) {
		if (length > 0 && length <= 12) {
			this.length = length;
		}
		switch (mixStyle) {
			case NUMBER:
				this.words = number; break;
			case LOWERCASE:
				this.words = lowerCase; break;
			case UPPERCASE:
				this.words = upperCase; break;
			case NUMBER_LOWERCASE:
				this.words = number + lowerCase; break;
			case NUMBER_UPPERCASE:
				this.words = number + upperCase; break;
			case LOWER_UPPER_CASE:
				this.words = lowerCase + upperCase; break;
			case MIX_ALL:
				this.words = number + lowerCase + upperCase; break;
			default:
				this.words = number + lowerCase + upperCase;
		}
	}
	
	/**
	 * 生成验证码核心方法
	 */
	public String generate(OutputStream os) throws Exception {
		BufferedImage image = new BufferedImage(this.width, this.height,
				TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		g.setColor(this.getRandomColor(200, 250));
		g.fillRect(0, 0, this.width, this.height);
		g.setFont(this.getRandomFont());
		g.setColor(this.getRandomColor(180, 200));
		Random random = new Random();
		for (int i = 0; i < 130; i++) {
			int x = random.nextInt(this.width - 1);
			int y = random.nextInt(this.height - 1);
			int x1 = random.nextInt(6) + 1;
			int y1 = random.nextInt(12) + 1;
			Stroke stroke = new BasicStroke(2, CAP_BUTT, JOIN_BEVEL);
			Shape shape = new Line2D.Double(x, y, x + x1, y + y1);
			g.setStroke(stroke);
			g.draw(shape);
		}
		StringBuilder sb = new StringBuilder();
		char[] words = this.words.toCharArray();
		int x = this.width / (this.length + 1);
		for (int i = 0; i < this.length; i++) {
			int index = random.nextInt(words.length - 1);
			String word = String.valueOf(words[index]);
			sb.append(word);
			int red = random.nextInt(110);
			int green = random.nextInt(110);
			int blue = random.nextInt(110);
			Color color = new Color(20 + red, 20 + green, 20 + blue);
			g.setColor(color);
			g.drawString(word, x * i + x / 2, this.height - 4);
		}
		g.dispose();
		ImageIO.write(image, IMAGETYPE, os);
		return sb.toString();
	}
	
	/**
	 * 生成验证码核心方法
	 */
	public void generate(String code, OutputStream os) throws Exception {
		if (StringUtil.isNotEmpty(code)) {
			this.length = code.length();
			this.width = code.length()*20;
		}
		
		BufferedImage image = new BufferedImage(this.width, this.height,
				TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		g.setColor(this.getRandomColor(200, 250));
		g.fillRect(0, 0, this.width, this.height);
		g.setFont(this.getRandomFont());
		g.setColor(this.getRandomColor(180, 200));
		Random random = new Random();
		for (int i = 0; i < 130; i++) {
			int x = random.nextInt(this.width - 1);
			int y = random.nextInt(this.height - 1);
			int x1 = random.nextInt(6) + 1;
			int y1 = random.nextInt(12) + 1;
			Stroke stroke = new BasicStroke(2, CAP_BUTT, JOIN_BEVEL);
			Shape shape = new Line2D.Double(x, y, x + x1, y + y1);
			g.setStroke(stroke);
			g.draw(shape);
		}
		int x = this.width / (this.length + 1);
		for (int i = 0; i < this.length; i++) {
			String word = String.valueOf(code.charAt(i));
			int red = random.nextInt(110);
			int green = random.nextInt(110);
			int blue = random.nextInt(110);
			Color color = new Color(20 + red, 20 + green, 20 + blue);
			g.setColor(color);
			g.drawString(word, x * i + x / 2, this.height - 4);
		}
		g.dispose();
		ImageIO.write(image, IMAGETYPE, os);
	}

	/**
	 * 获取随机颜色
	 * 
	 * @return
	 */
	private Color getRandomColor(int i, int j) {
		if (i > 255)
			i = 255;
		if (j > 255)
			j = 255;
		Random random = new Random();
		int r = i + random.nextInt(j - i);
		int g = i + random.nextInt(j - i);
		int b = i + random.nextInt(j - i);
		Color color = new Color(r, g, b);
		return color;
	}

	/**
	 * 获取随机字体
	 * 
	 * @return
	 */
	private Font getRandomFont() {
		String[] fonts = this.fonts.split(",");
		Random random = new Random();
		int index = random.nextInt(fonts.length - 1);
		Font font = new Font(fonts[index], this.fontStyle, this.height - 8);
		return font;
	}

	/**
	 * @param width
	 *            图片宽度
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @param height
	 *            图片高度
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @param length
	 *            验证码长度
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * @param fontStyle
	 *            字体样式
	 */
	public void setFontStyle(int fontStyle) {
		this.fontStyle = fontStyle;
	}

	/**
	 * @param fonts
	 *            字体
	 */
	public void setFonts(String fonts) {
		this.fonts = fonts;
	}

	/**
	 * @param words
	 *            字符内容
	 */
	public void setWords(String words) {
		this.words = words;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getLowerCase() {
		return lowerCase;
	}

	public void setLowerCase(String lowerCase) {
		this.lowerCase = lowerCase;
	}

	public String getUpperCase() {
		return upperCase;
	}

	public void setUpperCase(String upperCase) {
		this.upperCase = upperCase;
	}
	
}
