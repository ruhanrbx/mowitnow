package fr.com.mowitnow.model;

/**
 * Created by ruhan.silva on 15/05/2017.
 */
public enum Orientation {
    N, W, E, S;

    static {
        N.left = W;
        N.right = E;
        W.left = S;
        W.right = N;
        E.left = N;
        E.right = S;
        S.left = E;
        S.right = W;
    }

    private Orientation left;
    private Orientation right;
    public static int LEFT = -1;
    public static int RIGHT = 1;

    public static Orientation findByName(String string) {
        for (Orientation o : values()) {
            if (o.name().equals(string)) {
                return o;
            }
        }
        return null;
    }

    public Orientation turnTo(int t) {
        return t == LEFT ? left : right;
    }

}



