package ga.veee.day23.control;

import java.util.ListResourceBundle;

public class Dictionary_ta extends ListResourceBundle{
	Object obj[][]= {
			{"username","பயனர்பெயர்"},
			{"password","கடவுச்சொல்"},
			{"hero1","புதிய மளிகை"},
			{"hero2","பொருட்கள்"},
			{"hero3","வாங்க"}
	};
@Override
protected Object[][] getContents() {
	// TODO Auto-generated method stub
	return obj;
}
	
}
