package user;
import lombok.*;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString
public class User {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String address;
    private String job;
    private double height;
    private double weight;

    @Builder(builderMethodName = "builder")
    public User(Long id, String username, String password,
                String name, String phone,
                String address, String job,
                double height, double weight) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.job = job;
        this.height = height;
        this.weight = weight;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{\n" +
                "username='" + username + '\n' +
                ", password='" + password + '\n' +
                ", name='" + name + '\n' +
                ", phone='" + phone + '\n' +
                ", address='" + address + '\n' +
                ", job='" + job + '\n' +
                '}';
    }
}