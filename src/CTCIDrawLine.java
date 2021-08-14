public class CTCIDrawLine {
    public static void main(String[] args) {
        try{
            CTCIDrawLine obj = new CTCIDrawLine();
            obj.run(args);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void run(String[] args){
        //Creates data(byte array)
        byte[] holdPixels = new byte[32];
        //Gets the result of drawing a line
        byte[] screenWithLine = drawLine(holdPixels,16,3,15,4);
        //Prints the bytes that have been written to
        System.out.println(screenWithLine[8]);
        System.out.println(screenWithLine[9]);
    }
    public byte[] drawLine(byte[] screen, int width, int x1, int x2, int y){
        int whichByte = (width/8)*y;
        whichByte+=x1/8;
        int positionInByte = x1 % 8;
        int numberOfPixels = x2-x1+1;
        while(numberOfPixels > 0){
            if(positionInByte == 8){
                positionInByte = 0;
                whichByte++;
            }
            screen[whichByte] = (byte) (screen[whichByte] | (1 << (7-positionInByte)));
            numberOfPixels--;
            positionInByte++;
        }
        return screen;
    }
}