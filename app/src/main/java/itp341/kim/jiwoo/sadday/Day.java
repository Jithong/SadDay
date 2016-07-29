package itp341.kim.jiwoo.sadday;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Jithong on 4/30/2016.
 */
public class Day {
    int food;
    int sleep;
    int fun;
    int relationships;
    String date;

    public Day() {
        super();
        String _date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        this.date = _date;

    };

    public Day(int _food, int _sleep, int _fun, int _relationships) {
        this.food = _food;
        this.sleep = _sleep;
        this.fun = _fun;
        this.relationships = _relationships;
        this.date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getSleep() {
        return sleep;
    }

    public void setSleep(int sleep) {
        this.sleep = sleep;
    }

    public int getFun() {
        return fun;
    }

    public void setFun(int fun) {
        this.fun = fun;
    }

    public int getRelationships() {
        return relationships;
    }

    public void setRelationships(int relationships) {
        this.relationships = relationships;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return this.date;
    }
}
