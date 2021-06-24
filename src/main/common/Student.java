package main.common;

public class Student implements Comparable<Student> {

    private String name;

    private String idCard;

    private int score;

    public Student(String name, String idCard, int score) {
        this.name = name;
        this.idCard = idCard;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || this.getClass() != o.getClass())
            return false;

        Student student = (Student) o;

        if (!this.name.equals(student.name))
            return false;

        return this.idCard.equals(student.idCard);
    }

    // 按成绩排序
    @Override
    public int compareTo(Student another) {
        return this.score - another.score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", idCard='" + idCard + '\'' +
                ", score=" + score +
                '}';
    }
}
