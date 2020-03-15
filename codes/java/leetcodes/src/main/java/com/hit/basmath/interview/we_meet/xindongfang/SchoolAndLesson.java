package com.hit.basmath.interview.we_meet.xindongfang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Charies Gavin
 * @github https:github.com/guobinhit
 * @date 2020/3/4,下午4:48
 * @description
 */
public class SchoolAndLesson {
    private List<School> schools;
    private List<Lesson> lessons;
    private List<String> schoolNames;


    public SchoolAndLesson() {
        schools = new ArrayList<>();
        lessons = new ArrayList<>();
        schoolNames = new ArrayList<>();
    }

    public static void main(String[] args) {
        SchoolAndLesson schoolAndLesson = new SchoolAndLesson();
        Lesson[] weLesson = new Lesson[schoolAndLesson.lessons.size()];
        for (int i = 0; i < schoolAndLesson.lessons.size(); i++) {
            weLesson[i] = schoolAndLesson.lessons.get(i);
            if (weLesson[i].studentCount > 1000) {
                for (School school : schoolAndLesson.schools) {
                    if (school.getShoolid() == weLesson[i].schoolid) {
                        schoolAndLesson.schoolNames.add(school.getSchoolname());
                    }
                }
            }
        }
        Arrays.sort(weLesson);
    }

    private class School {
        private int shoolid;
        private String schoolname; //学校名字

        public int getShoolid() {
            return shoolid;
        }

        public void setShoolid(int shoolid) {
            this.shoolid = shoolid;
        }

        public String getSchoolname() {
            return schoolname;
        }

        public void setSchoolname(String schoolname) {
            this.schoolname = schoolname;
        }
    }

    private class Lesson implements Comparable<Lesson> {
        private int schoolid;
        private int studentCount; //学生数量

        public int getSchoolid() {
            return schoolid;
        }

        public void setSchoolid(int schoolid) {
            this.schoolid = schoolid;
        }

        public int getStudentCount() {
            return studentCount;
        }

        public void setStudentCount(int studentCount) {
            this.studentCount = studentCount;
        }

        @Override
        public int compareTo(Lesson lesson) {
            if (lesson.studentCount < this.studentCount) {
                return -1;
            } else if (this.studentCount > lesson.studentCount) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
