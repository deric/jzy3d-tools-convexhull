package org.jzy3d.convexhull;

import java.util.Stack;
import org.jzy3d.convexhull.algorithms.Point2f;
import org.jzy3d.convexhull.algorithms.XYComparator;
import org.jzy3d.convexhull.utils.QuickSort;

/**
 * Luokka kääntyy, muttei toimi vielä. Edit: Lista on muutettu taulukoksi.
 *
 * @author Ossi Lehto
 */
public class JarvisMarch implements ConvexHullFunction {

    /**
     * @.pre {true}
     */
    public JarvisMarch() {
    }

    /**
     * Laskee kolmion p1p2p3 alan
     */
    private double crossProduct(Point2f p1, Point2f p2, Point2f p3) {
        return (p2.getX() - p1.getX()) * (p3.getY() - p1.getY()) - (p3.getX() - p1.getX()) * (p2.getY() - p1.getY());
    }

    /**
     * Palauttaa pinossa peitteen pisteet niin, että ensimmäinen ja viimeinen
     * alkio ovat samat.
     *
     *
     * .@pre {Q.length > 1}
     */
    @Override
    public Stack<Point2f> getConvexHull(Point2f[] Q) {
        QuickSort.<Point2f>sort(Q, new XYComparator());
        int lowest = 0;
        int highest = Q.length - 1;
        int n = 0;
        Stack<Integer> collinear = new Stack<Integer>();
        boolean pass = true;

        // Palautettava pino.
        Stack<Point2f> S = new Stack<Point2f>();
        S.push(Q[0]);

        /**
         * Oikea ketju *
         */
        while (n < highest) {
            n++;
            /* Kokeillaan pistettä n seuraavaksi palautettavaksi pisteeksi */
            for (int i = n + 1; i <= Q.length - 1; i++) {
                // löytyi piste, joka oli viivan väärällä puolella
                if (crossProduct(S.peek(), Q[n], Q[i]) < 0) {
                    pass = false;
                    break; // lopettaa ristitulojen tarkastamisen, pisteen vaihto
                }
                // löytyi kollineaarinen piste
                if (crossProduct(S.peek(), Q[n], Q[i]) == 0) {
                    collinear.push(i);
                }
            } // for

            // seuraava piste löydetty
            if (pass) {

                // Kollienaarisista pisteistä otetaan viimeiseksi lisätty,
                // koska se on kauimmainen
                if (!collinear.empty()) {
                    n = collinear.pop();
                }

                S.push(Q[n]);
            } // if
            // alustetaan tarkistus
            while (!collinear.empty()) {
                collinear.pop();
            }
            pass = true;

        } // while

        /**
         * Vasen ketju, tässä vaiheessa n==highest *
         */
        while (n > lowest) {
            n--;
            // Kokeillaan pistettä n seuraavaksi palautettavaksi pisteeksi
            for (int i = n - 1; i >= 0; i--) {
                // löytyi piste, joka oli viivan väärällä puolella
                if (crossProduct(Q[n], S.peek(), Q[i]) > 0) {
                    pass = false;
                    // lopettaa ristitulojen tarkastamisen, pisteen vaihto
                    break;
                }

                // löytyi kollineaarinen piste
                if (crossProduct(Q[n], S.peek(), Q[i]) == 0) {
                    collinear.push(i);
                }

            } // for

            // seuraava piste löydetty
            if (pass) {

                // Kollienaarisista pisteistä otetaan viimeiseksi lisätty,
                // koska se on kauimmainen
                if (!collinear.empty()) {
                    n = collinear.pop();
                }

                S.push(Q[n]);
            } // if
            // alustetaan tarkistus
            while (!collinear.empty()) {
                collinear.pop();
            }
            pass = true;

        } // while

        return S;
    }
} // end of class
