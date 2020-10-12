package uk.ac.warwick.dcs.chess.piece;
import uk.ac.warwick.dcs.chess.*;
public class King extends ChessPiece {
    private static final long serialVersionUID = 1L;
    public King(Board board, boolean isWhite, int vertical, int horizontal) {
        super(board, isWhite, (char)((int)ChessIcons.W_KING + (isWhite ? 0 : 6)), vertical, horizontal);
    }

    @Override
    public Move[] getAvailableMoves() {
        availableMoves.clear();

        int moveH, moveV;

        // Up
        moveV = this.vertical - 1;
        moveH = this.horizontal;
        addMove(moveV, moveH);

        // Down
        moveV = this.vertical + 1;
        moveH = this.horizontal;
        addMove(moveV, moveH);

        // Right
        moveV = this.vertical;
        moveH = this.horizontal + 1;
        addMove(moveV, moveH);

        // Left
        moveV = this.vertical;
        moveH = this.horizontal - 1;
        addMove(moveV, moveH);

        // Top Right
        moveV = this.vertical - 1;
        moveH = this.horizontal + 1;
        addMove(moveV, moveH);

        // Top Left
        moveV = this.vertical - 1;
        moveH = this.horizontal - 1;
        addMove(moveV, moveH);

        // Bottom Right
        moveV = this.vertical + 1;
        moveH = this.horizontal + 1;
        addMove(moveV, moveH);

        // Bottom Left
        moveV = this.vertical + 1;
        moveH = this.horizontal - 1;
        addMove(moveV, moveH);


        return availableMoves.movesToArray();
    }

    private void addMove(int moveV, int moveH) {
      // To empty space.
      if (board.locationValid(moveV, moveH) && board.pieceAtLocation(moveV, moveH) == null) {
        Move m = new Move(this, moveV,moveH, false);
        availableMoves.add(m);
      }

      // To take piece.
      if (board.locationValid(moveV, moveH) && board.pieceAtLocation(moveV, moveH) != null && board.pieceAtLocation(moveV, moveH).isWhite != this.isWhite) {
        Move m = new Move(this, moveV,moveH, true);
        availableMoves.add(m);
      }
    }
}
