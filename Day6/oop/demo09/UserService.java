package oop.demo09;

public interface UserService {
    //接口中的所有定义都是抽象的
    //接口需要有实践类
    void add(String name);
    void delete(String name);
    void update(String name);
    void query(String name);
    //属性为常量
    int AGE=99;
}
