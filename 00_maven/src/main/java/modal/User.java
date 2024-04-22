package modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
// 無參數建構式
@NoArgsConstructor
// 所有參數建構式
@AllArgsConstructor
public class User {

	private String name;
	
	private String password;
}
