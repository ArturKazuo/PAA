// Part of OpenGenus IQ
class somaSubconjuntoBruta 
{
    static boolean somaSubconjuntoBool(int list[], int starting_index, int sum)
    {
        if (sum == 0)
            return true;
        if (list.length - starting_index == 1)
             if(list[starting_index] == sum)
                 return true;
             else
                 return false;
         
         boolean result_1 = somaSubconjuntoBool(list, starting_index + 1, sum - list[starting_index]);
         
         boolean result_2 = somaSubconjuntoBool(list, starting_index + 1, sum);
         
         return result_1 | result_2;      
    }
    
    static boolean somaSubconjunto(int list[], int sum)
    {
        if(list.length < 1)
            return false;
        if(list.length == 1)
            if(list[0] == sum) 
                return true;
            else
                return false;
                
        return somaSubconjuntoBool(list, 0, sum);
    }

	public static void main (String[] args) 
	{
	    // int list[] = {2, 1, 99, 3, 2, 9, 10, 1, 99, 3, 9, 10, 1, 99, 1, 99, 3, 2, 9, 10, 1, 99, 3, 9, 10, 1, 99, 1, 99, 3, 2, 9};
	    int list[] = {2, 1, 99, 3, 5};
        // int list[] = {2, 1, 99, 3, 5, 1, 99, 3, 5, 10};
        // int list[] = {2, 1, 99, 3, 5, 1, 99, 3, 5, 10, 2, 1, 99, 3, 5, 1, 99, 3, 5, 10};
        // int list[] = {2, 1, 99, 3, 5, 1, 99, 3, 5, 10, 2, 1, 99, 3, 5, 1, 99, 3, 5, 10, 2, 1, 99, 3, 5, 1, 99, 3, 5, 10};
        // int list[] = {2, 1, 99, 3, 5, 1, 99, 3, 5, 102, 1, 99, 3, 5, 1, 99, 3, 5, 10, 2, 1, 99, 3, 5, 1, 99, 3, 5, 10, 2, 1, 99, 3, 5, 1, 99, 3, 5, 10, 2, 1, 99, 3, 5, 1, 99, 3, 5, 10};
        // int list[] = {2, 1, 99, 3, 5, 1, 99, 3, 5, 102, 1, 99, 3, 5, 1, 99, 3, 5, 10, 2, 1, 99, 3, 5, 1, 99, 3, 5, 10, 2, 1, 99, 3, 5, 1, 99, 3, 5, 10, 2, 1, 99, 3, 5, 1, 99, 3, 5, 10, 2, 1, 99, 3, 5, 1, 99, 3, 5, 10, 2, 1, 99, 3, 5, 1, 99, 3, 5, 10, 2, 1, 99, 3, 5, 1, 99, 3, 5, 10, 2, 1, 99, 3, 5, 1, 99, 3, 5, 10, 2, 1, 99, 3, 5, 1, 99, 3, 5, 10};
        long tempoInicial = System.nanoTime();
        boolean bool = somaSubconjunto(list, 6);
		System.out.println(bool);
        long tempoFinal = System.nanoTime();
        long tempo = tempoFinal - tempoInicial;
        System.out.println(tempo);
        System.out.println(tempoInicial);
        System.out.println(tempoFinal);
	}
}