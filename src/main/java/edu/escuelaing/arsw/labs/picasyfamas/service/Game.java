package edu.escuelaing.arsw.labs.picasyfamas.service;

public class Game {

    private int p;
    private int f;
    private int goal;
    private int current;
    private int attempts;
    private Integer digits;
    private boolean run;

    public Game(Integer digits) {
        if (digits != null) {
            this.digits = digits;
            generateRandomNum();
            attempts = 2 * digits;
            run = true;
        }
    }

    public void play() {
        p();
        f();
        attempts--;
        if (attempts == 0 || f == digits) {
            run = false;
        }
    }

    private void p() {
        String sGoal = String.valueOf(goal);
        String sCurrent = String.valueOf(current);
        int cont = 0;
        for (char c : sCurrent.toCharArray()) {
            if (sGoal.contains(String.valueOf(c))) {
                sGoal = sGoal.replaceFirst(String.valueOf(c), "");
                cont++;
            }
        }
        p = cont;
    }

    private void f() {
        String sGoal = String.valueOf(goal);
        String sCurrent = String.valueOf(current);
        int cont = 0;
        for (int i = 0; i < Math.min(sGoal.length(), sCurrent.length()); i++) {
            if (sGoal.charAt(i) == sCurrent.charAt(i)) {
                cont++;
            }
        }
        f = cont;
    }

    private void generateRandomNum() {
        Number n = Math.random() * Math.pow(10, digits);
        goal = n.intValue();
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attemps) {
        this.attempts = attemps;
    }

    public Integer getDigits() {
        return digits;
    }

    public void setDigits(Integer digits) {
        this.digits = digits;
    }

    public boolean getRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    @Override
    public String toString() {
        return "Service [attemps=" + attempts + ", current=" + current + ", digits=" + digits + ", f=" + f + ", goal="
                + goal + ", p=" + p + ", run=" + run + "]";
    }

}
