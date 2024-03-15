
CREATE TABLE menus(
    id INT NOT NULL AUTO_INCREMENT,
    category VARCHAR(20),
    item VARCHAR(20)
);
insert into menus(item,category) values ('회원가입','users');
insert into menus(item,category) values ('로그인','login');
insert into menus(item,category) values('아이디찾기','');
insert into menus(item,category) values ('비밀번호찾기','');