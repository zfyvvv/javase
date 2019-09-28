package cn.zhoufy.annotation.b;
/**
 * 2-Ê¹ÓÃ×¢½â
 * @author DELL
 *
 */
@SetTable(value="Tb_students")
@SetTable2("aaaaaaaaaaaaaaaaa")
public class Students {
	
	@SetField(columnName="sname",type="varchar",length=10)
	private String name;
	@SetField(columnName="id",type="int",length=10)
	private int  id;
	@SetField(columnName="grade",type="varchar",length=10)
	private  String grade;
	
	public Students(String name, int id, String grade) {
		super();
		this.name = name;
		this.id = id;
		this.grade = grade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	
}
