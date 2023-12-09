import java.util.*;
 
class Job {
   
    //Cada trabalho tem um id, lucro e deadline
    int id;
    int deadline, penalization;
 
    // Constructors
    public Job() {}
 
    public Job(int id, int deadline, int penalization)
    {
        this.id = id;
        this.deadline = deadline;
        this.penalization = penalization;
    }
 
    
    void printJobScheduling(ArrayList<Job> arr, int t)
    {
        int n = arr.size();
        int max = 0;

        for(int j=0; j<n; j++){
            if(arr.get(j).deadline > max){
                max = arr.get(j).deadline;
            }
        }

        Job[][] matrix = new Job[max][n];

        for(int i=0; i<max; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = new Job(0, 0, 101);
            }
        }

        // for(int i=0; i<max; i++){
        //     for(int j=0; j<n; j++){
        //         System.out.println("aqui; " + i + " " + matrix[i][j].id );
        //     }
        // }

        for(int i=0; i<n; i++){
            Job job = arr.get(i);
            for(int j=0; j<n-1; j++){
                if(matrix[arr.get(i).deadline-1][j].penalization > job.penalization){
                    Job tmp = matrix[arr.get(i).deadline-1][j];
                    matrix[arr.get(i).deadline-1][j] = job;
                    matrix[arr.get(i).deadline-1][j+1] = tmp;
                    break;
                }
            }
        }

        System.out.println("aqui estao as escolhas certas nas ordens certas: ");

        for(int i=max-1; i>=0; i--){
            for(int j=0; j<n; j++){
                if(matrix[i][j].id != 0){
                    System.out.println("aqui; " + (i+1) + " | " + matrix[i][j].id );
                }   
            }
        }
    
    }
 
    public static void main(String args[])
    {
        long tempoInicial = System.nanoTime();
        ArrayList<Job> arr = new ArrayList<Job>();

        // 5 elementos

        // arr.add(new Job(1, 2, 100));
        // arr.add(new Job(2, 1, 19));
        // arr.add(new Job(3, 2, 27));
        // arr.add(new Job(4, 10, 25));
        // arr.add(new Job(5, 3, 15));

        // 10 elementos

        arr.add(new Job(1, 2, 100));
        arr.add(new Job(2, 10, 19));
        arr.add(new Job(3, 2, 27));
        arr.add(new Job(4, 10, 25));
        arr.add(new Job(5, 3, 15));
        arr.add(new Job(6, 2, 99));
        arr.add(new Job(7, 10, 1));
        arr.add(new Job(8, 2, 27));
        arr.add(new Job(9, 10, 20));
        arr.add(new Job(10, 3, 10));

        // 30 elementos

        // arr.add(new Job(1, 2, 100));
        // arr.add(new Job(2, 10, 19));
        // arr.add(new Job(3, 2, 27));
        // arr.add(new Job(4, 1, 25));
        // arr.add(new Job(5, 3, 15));
        // arr.add(new Job(6, 2, 99));
        // arr.add(new Job(7, 9, 1));
        // arr.add(new Job(8, 2, 27));
        // arr.add(new Job(9, 8, 20));
        // arr.add(new Job(10, 5, 10));
        // arr.add(new Job(11,6, 100));
        // arr.add(new Job(12, 7, 19));
        // arr.add(new Job(13, 8, 47));
        // arr.add(new Job(14, 9, 75));
        // arr.add(new Job(15, 3, 15));
        // arr.add(new Job(16, 10, 99));
        // arr.add(new Job(17, 6, 1));
        // arr.add(new Job(18, 10, 27));
        // arr.add(new Job(19, 4, 20));
        // arr.add(new Job(20, 3, 10));
        // arr.add(new Job(21, 2, 100));
        // arr.add(new Job(22, 7, 39));
        // arr.add(new Job(23, 2, 37));
        // arr.add(new Job(24, 10, 35));
        // arr.add(new Job(25, 3, 45));
        // arr.add(new Job(26, 2, 49));
        // arr.add(new Job(27, 10, 31));
        // arr.add(new Job(28, 2, 37));
        // arr.add(new Job(29, 10, 30));
        // arr.add(new Job(30, 3, 30));

        // 50 elementos

        // arr.add(new Job(1, 2, 100));
        // arr.add(new Job(2, 10, 19));
        // arr.add(new Job(3, 2, 27));
        // arr.add(new Job(4, 1, 25));
        // arr.add(new Job(5, 3, 15));
        // arr.add(new Job(6, 2, 99));
        // arr.add(new Job(7, 9, 1));
        // arr.add(new Job(8, 2, 27));
        // arr.add(new Job(9, 8, 20));
        // arr.add(new Job(10, 5, 10));
        // arr.add(new Job(11,6, 100));
        // arr.add(new Job(12, 7, 19));
        // arr.add(new Job(13, 8, 47));
        // arr.add(new Job(14, 9, 75));
        // arr.add(new Job(15, 3, 15));
        // arr.add(new Job(16, 10, 99));
        // arr.add(new Job(17, 6, 1));
        // arr.add(new Job(18, 10, 27));
        // arr.add(new Job(19, 4, 20));
        // arr.add(new Job(20, 3, 10));
        // arr.add(new Job(21, 2, 100));
        // arr.add(new Job(22, 7, 39));
        // arr.add(new Job(23, 2, 37));
        // arr.add(new Job(24, 10, 35));
        // arr.add(new Job(25, 3, 45));
        // arr.add(new Job(26, 2, 49));
        // arr.add(new Job(27, 10, 31));
        // arr.add(new Job(28, 2, 37));
        // arr.add(new Job(29, 10, 30));
        // arr.add(new Job(30, 3, 30));
        // arr.add(new Job(31, 2, 98));
        // arr.add(new Job(32, 10, 12));
        // arr.add(new Job(33, 2, 13));
        // arr.add(new Job(34, 1, 11));
        // arr.add(new Job(35, 3, 1));
        // arr.add(new Job(36, 2, 9));
        // arr.add(new Job(37, 9, 21));
        // arr.add(new Job(38, 2, 7));
        // arr.add(new Job(39, 8, 40));
        // arr.add(new Job(40, 5, 40));
        // arr.add(new Job(41,6, 41));
        // arr.add(new Job(42, 7, 49));
        // arr.add(new Job(43, 8, 67));
        // arr.add(new Job(44, 9, 65));
        // arr.add(new Job(45, 3, 75));
        // arr.add(new Job(46, 10, 79));
        // arr.add(new Job(47, 6, 17));
        // arr.add(new Job(48, 10, 77));
        // arr.add(new Job(49, 4, 80));
        // arr.add(new Job(50, 3, 81));
    
        // 100 elementos
        
        // arr.add(new Job(1, 2, 100));
        // arr.add(new Job(2, 10, 19));
        // arr.add(new Job(3, 2, 27));
        // arr.add(new Job(4, 1, 25));
        // arr.add(new Job(5, 3, 15));
        // arr.add(new Job(6, 2, 99));
        // arr.add(new Job(7, 9, 1));
        // arr.add(new Job(8, 2, 27));
        // arr.add(new Job(9, 8, 20));
        // arr.add(new Job(10, 5, 10));
        // arr.add(new Job(11,6, 100));
        // arr.add(new Job(12, 7, 19));
        // arr.add(new Job(13, 8, 47));
        // arr.add(new Job(14, 9, 75));
        // arr.add(new Job(15, 3, 15));
        // arr.add(new Job(16, 10, 99));
        // arr.add(new Job(17, 6, 1));
        // arr.add(new Job(18, 10, 27));
        // arr.add(new Job(19, 4, 20));
        // arr.add(new Job(20, 3, 10));
        // arr.add(new Job(21, 2, 100));
        // arr.add(new Job(22, 7, 39));
        // arr.add(new Job(23, 2, 37));
        // arr.add(new Job(24, 10, 35));
        // arr.add(new Job(25, 3, 45));
        // arr.add(new Job(26, 2, 49));
        // arr.add(new Job(27, 10, 31));
        // arr.add(new Job(28, 2, 37));
        // arr.add(new Job(29, 10, 30));
        // arr.add(new Job(30, 3, 30));
        // arr.add(new Job(31, 2, 98));
        // arr.add(new Job(32, 10, 12));
        // arr.add(new Job(33, 2, 13));
        // arr.add(new Job(34, 1, 11));
        // arr.add(new Job(35, 3, 1));
        // arr.add(new Job(36, 2, 9));
        // arr.add(new Job(37, 9, 21));
        // arr.add(new Job(38, 2, 7));
        // arr.add(new Job(39, 8, 40));
        // arr.add(new Job(40, 5, 40));
        // arr.add(new Job(41,6, 41));
        // arr.add(new Job(42, 7, 49));
        // arr.add(new Job(43, 8, 67));
        // arr.add(new Job(44, 9, 65));
        // arr.add(new Job(45, 3, 75));
        // arr.add(new Job(46, 10, 79));
        // arr.add(new Job(47, 6, 17));
        // arr.add(new Job(48, 10, 77));
        // arr.add(new Job(49, 4, 80));
        // arr.add(new Job(50, 3, 81));
        // arr.add(new Job(51, 2, 1));
        // arr.add(new Job(52, 10, 4));
        // arr.add(new Job(53, 2, 5));
        // arr.add(new Job(54, 1, 26));
        // arr.add(new Job(55, 3, 6));
        // arr.add(new Job(56, 2, 29));
        // arr.add(new Job(57, 9, 7));
        // arr.add(new Job(58, 2, 87));
        // arr.add(new Job(59, 8, 9));
        // arr.add(new Job(60, 5, 11));
        // arr.add(new Job(61,6, 1));
        // arr.add(new Job(62, 7, 11));
        // arr.add(new Job(63, 8, 40));
        // arr.add(new Job(64, 9, 95));
        // arr.add(new Job(65, 3, 15));
        // arr.add(new Job(66, 10, 99));
        // arr.add(new Job(67, 6, 91));
        // arr.add(new Job(68, 10, 97));
        // arr.add(new Job(69, 4, 92));
        // arr.add(new Job(70, 3, 10));
        // arr.add(new Job(71, 2, 100));
        // arr.add(new Job(72, 7, 29));
        // arr.add(new Job(73, 2, 7));
        // arr.add(new Job(74, 10, 3));
        // arr.add(new Job(75, 3, 4));
        // arr.add(new Job(76, 2, 9));
        // arr.add(new Job(77, 10, 1));
        // arr.add(new Job(78, 2, 3));
        // arr.add(new Job(79, 10, 30));
        // arr.add(new Job(70, 3, 40));
        // arr.add(new Job(81, 2, 91));
        // arr.add(new Job(82, 10, 100));
        // arr.add(new Job(83, 2, 13));
        // arr.add(new Job(84, 1, 11));
        // arr.add(new Job(85, 3, 1));
        // arr.add(new Job(86, 2, 9));
        // arr.add(new Job(87, 9, 21));
        // arr.add(new Job(88, 2, 7));
        // arr.add(new Job(89, 8, 40));
        // arr.add(new Job(90, 5, 42));
        // arr.add(new Job(91,6, 41));
        // arr.add(new Job(92, 7, 46));
        // arr.add(new Job(93, 8, 66));
        // arr.add(new Job(94, 9, 66));
        // arr.add(new Job(95, 3, 76));
        // arr.add(new Job(96, 10, 79));
        // arr.add(new Job(97, 6, 16));
        // arr.add(new Job(98, 10, 77));
        // arr.add(new Job(99, 4, 86));
        // arr.add(new Job(100, 3, 81));

 
        System.out.println("Aqui está a sequencia de trabalhos: ");
 
        Job job = new Job();
 
        job.printJobScheduling(arr, 5);
        long tempoFinal = System.nanoTime();
        long tempo = tempoFinal - tempoInicial;
        System.out.println(tempo/1000);
        // System.out.println(tempoInicial);
        // System.out.println(tempoFinal);
    }
}
 