package it.unive.dais.po1.exercise2.m879607;
import it.unive.dais.po1.exercise2.Board;
import it.unive.dais.po1.exercise2.Mark;

public class GomokuBoard extends Board {
    /**
     * Creates a square board
     *
     * @param dimension the dimension of the square board
     */
    public GomokuBoard(int dimension) {
        super(dimension);
    }

    /**
     * Returns the winner of the game
     *
     * @return the mark of the winner of the game, or null if there is not yet a winner
     */
    @Override
    public Mark winner() {
        for(int i=0;i<getDimension();i++) {
            for (int j = 0; j < getDimension(); j++) {
                    if(checkrow(i, j)!=null)
                            return checkrow(i,j);
                    if(checkcoloumn(i, j)!=null)
                            return checkcoloumn(i,j);
                    if(checkfirstdiagonal(i, j)!=null)
                            return checkfirstdiagonal(i,j);
                    if(checkseconddiagonal(i, j)!=null)
                        return checkseconddiagonal(i,j);
            }
        }
        return null;
    }

    private Mark checkrow(int i, int j) {
        if(j+4>getDimension()-1)
            return null;
        Mark aux = getMark(i,j);
        for(int c=0;c<5;c++)
            if(aux!=getMark(i,j+c))
                return null;

        return aux;
    }

    private Mark checkcoloumn(int i, int j) {
        if(i+4>getDimension()-1)
            return null;
        Mark aux = getMark(i,j);
        for(int c=0;c<5;c++)
            if(aux!=getMark(i+c,j))
                return null;

        return aux;
    }

    private Mark checkfirstdiagonal(int i, int j) {
        if(j+4>getDimension()-1||i+4>getDimension()-1)
            return null;
        Mark aux = getMark(i,j);
        for(int c=0;c<5;c++)
            if(aux!=getMark(i+c,j+c))
                return null;

        return aux;
    }

    private Mark checkseconddiagonal(int i, int j) {
        if(j-4<0||i+4>getDimension()-1)
            return null;
        Mark aux = getMark(i,j);
        for(int c=0;c<5;c++)
            if(aux!=getMark(i+c,j-c))
                return null;

        return aux;
    }

}
