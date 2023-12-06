public class somaSubconjuntoBacktracking
{
    static int subset_count = 0; 
   
    static void somaSubconjunto(int list[], int sum, int starting_index, int target_sum) 
    { 
        if( target_sum == sum ) 
        { 
            subset_count++;

        } 
        else
        { 
            for( int i = starting_index; i < list.length; i++ ) 
            { 
                somaSubconjunto(list, sum + list[i], i + 1, target_sum); 
            } 
        } 
    } 
    
    public static void main(String args[])
    {
        int list[] = {2, 1, 99, 3, 5};
        // int list[] = {2, 1, 99, 3, 5, 1, 99, 3, 5, 10};
        // int list[] = {2, 1, 99, 3, 5, 1, 99, 3, 5, 10, 2, 1, 99, 3, 5, 1, 99, 3, 5, 10};
        // int list[] = {2, 1, 99, 3, 5, 1, 99, 3, 5, 10, 2, 1, 99, 3, 5, 1, 99, 3, 5, 10, 2, 1, 99, 3, 5, 1, 99, 3, 5, 10};
        // int list[] = {2, 1, 99, 3, 5, 1, 99, 3, 5, 102, 1, 99, 3, 5, 1, 99, 3, 5, 10, 2, 1, 99, 3, 5, 1, 99, 3, 5, 10, 2, 1, 99, 3, 5, 1, 99, 3, 5, 10, 2, 1, 99, 3, 5, 1, 99, 3, 5, 10};
        long tempoInicial = System.nanoTime();
        somaSubconjunto(list, 0, 0, 6);
        System.out.println(subset_count);
        long tempoFinal = System.nanoTime();
        long tempo = tempoFinal - tempoInicial;
        System.out.println(tempo/1000);
        // System.out.println(tempoInicial);
        // System.out.println(tempoFinal);
    }
}