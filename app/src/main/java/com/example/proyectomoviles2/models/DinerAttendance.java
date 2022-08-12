package com.example.proyectomoviles2.models;

public class DinerAttendance{

    private Integer id;
    private Diner diner;
    private DayAttendance dayAttendance;
    private boolean attended=false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Diner getDiner() {
        return diner;
    }

    public void setDiner(Diner diner) {
        this.diner = diner;
    }

    public DayAttendance getDayAttendance() {
        return dayAttendance;
    }

    public void setDayAttendance(DayAttendance dayAttendance) {
        this.dayAttendance = dayAttendance;
    }

    public boolean isAttended() {
        return attended;
    }

    public void setAttended(boolean attended) {
        this.attended = attended;
    }
}
