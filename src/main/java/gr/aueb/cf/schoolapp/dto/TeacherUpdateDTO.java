package gr.aueb.cf.schoolapp.dto;

public class TeacherUpdateDTO extends BaseDTO{
    private Integer id;

    public TeacherUpdateDTO() {}

    public TeacherUpdateDTO(Integer id, String firstname, String lastname, String vat,
                            String fathername, String phoneNum, String email, String street,
                            String streetNum, String zipcode, Integer cityId) {
        super(firstname, lastname, vat, fathername, phoneNum, email, street, streetNum, zipcode, cityId);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
