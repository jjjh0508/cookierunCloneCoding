package cookierun;
// 배경
import java.awt.Image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data // getter setter toString equals, hashCode를 자동으로 생성 
@NoArgsConstructor  // 매개변수가 없는 생성자
@AllArgsConstructor // 모든 매개변수가 있는 생성자
public class Back {
	private Image image;
	private int x;
	private int y;
	private int width;
	private int height;
	
}
