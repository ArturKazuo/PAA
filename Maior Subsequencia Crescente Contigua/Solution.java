class Solution {
    private static int max;
    private static int contador;

    public static void main(String args[]){
        int[] arr = {10, 22, 9, 33, 21};
        // int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 21, 50};
        // int[] arr = {10, 22, 9, 33, 21, 33, 21, 50, 41, 60, 33, 21, 50, 41, 60, 77, 21, 50, 41, 60, 77, 21, 50, 111, 100, 33, 21, 50, 111, 140};
        // int[] arr = {10, 22, 9, 33, 21, 33, 21, 50, 41, 60, 33, 21, 50, 41, 60, 77, 21, 50, 41, 60, 77, 21, 50, 111, 100, 33, 21, 50, 111, 140, 77, 64, 50, 135, 155, 33, 64, 50, 135, 140, 77, 64, 180, 135, 155, 33, 126, 180, 135, 140};
        // int[] arr = {10, 22, 9, 33, 21, 33, 21, 50, 41, 60, 33, 21, 50, 41, 60, 77, 21, 50, 41, 60, 77, 21, 50, 111, 100, 33, 21, 50, 111, 140, 77, 64, 50, 135, 155, 33, 64, 50, 135, 140, 77, 64, 180, 135, 155, 33, 126, 180, 135, 140, 100, 198, 254, 190, 245, 190, 245, 50, 41, 60, 190, 245, 50, 41, 259, 77, 245, 50, 41, 259, 77, 21, 50, 111, 100, 33, 269, 50, 111, 140, 77, 64, 50, 135, 155, 300, 345, 367, 135, 140, 77, 345, 180, 135, 155, 400, 126, 180, 135, 140};
        long tempoInicial = System.nanoTime();
        System.out.println(tamanhoMSCC(arr));
        long tempoFinal = System.nanoTime();
        long tempo = tempoFinal - tempoInicial;
        System.out.println(tempo/1000);
        // System.out.println(tempoInicial);
        // System.out.println(tempoFinal);
  
    }
    
    public static class Elemento{
        int val;
        int max;
        public Elemento(int val, int id){
            this.val=val;
            this.max=1;
        }
    }

    public static int tamanhoMSCC(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        max=1;
        contador = 1;
        Elemento[] list = new Elemento[nums.length];
        for(int i=0;i<nums.length;i++){
            list[i]=new Elemento(nums[i], i);
        }
        mergeSortMSCC(list, 0, list.length-1);
        return contador;
    }
    
    public static void mergeSortMSCC(Elemento[] list, int s, int e){// a variavel "s" é onde se inicia a partição do array e "e" é onde termina
         if(s==e){
            return; 
        }
        int half=s+(e-s)/2;
        mergeSortMSCC(list, s, half);
        mergeSortMSCC(list, half+1, e);
        int i=s, j=half+1, count=0, preMax=0;
        Elemento[] result=new Elemento[e-s+1];
        //Para a lista do lado direito, se um nó com max=1 for aumentado em 2, então os nós com max=2 aumentarão para max(max(2+2, preMax+1))
        int[] mem=new int[half-s+2]; //memória de quanto é aumentado para a lista do lado direito.
        int temp;
        while(i<=half || j<=e){
            //Se o lado esquerdo = lado direito, limpa primeiro o lado esquerdo.
            if (i<=half && j<=e && list[i].val==list[j].val){
                temp=list[j].max;
                list[j].max=Math.max((mem[list[j].max-1]+list[j].max), preMax+1);
                while(i<=half && list[i].val==list[j].val){
                    result[count]=list[i];
                    count++;
                    i++;
                }
                mem[temp]=list[j].max-temp;
                result[count]=list[j];
                count++;
                j++;
                contador = 1;
                // System.out.println("contador =" + contador);
                continue;
            }

            //Se o lado esquerdo > lado direito, atualiza a contagem máxima do lado esquerdo.
            if(j>e  || (i<=half && list[i].val<list[j].val)){
                preMax=Math.max(preMax, list[i].max);
                result[count]=list[i];
                i++;
                count++;
                contador = 1;
                // System.out.println("contador menor" + contador);

            //Se o lado direito > lado esquerdo, a contagem máxima é um nó anterior do lado direito aumentado ou  max do lado esquerdo +1.
            } else if (i>half || (j<=e && list[i].val>list[j].val)){
                temp=list[j].max;
                list[j].max=Math.max((mem[list[j].max-1]+list[j].max), preMax+1);
                mem[temp]=list[j].max-temp;
                max=Math.max(max, list[j].max);
                result[count]=list[j];
                j++;
                count++;
                contador++;
                // System.out.println("contador maior " + contador);
            }
        }
        for(int k=0;k<count;k++){
            list[s+k]=result[k];
        }
    }
}