
public class MainClass {

   private static int numBlocosParaCortar = 7;
   private static int larguraInicial = 1000;
   private static int larguras[]={650,500,250,380, 220, 110, 60};
   private static int quantidadesTotaisPorLargura[]={4,3,6,5,5,3,7};
   private static int quantidadesRestantes[] = quantidadesTotaisPorLargura;

   public static void main(String[] args) {
      buscaPorHeuristica();
      mostrarQuantidadesRestantes();
   }

   private static void buscaPorHeuristica() {
      for(int i=0;i<numBlocosParaCortar;i++) {
         int tamanhoUtilizado = 0;
         int numMaxDeDivisoes = larguraInicial/larguras[buscarMenorLarguraRestante()];
         for(int j=0;j<numMaxDeDivisoes;j++) {  
            int indiceMenorBloco = buscarMenorLarguraRestante();          
            if(tamanhoUtilizado + larguras[indiceMenorBloco] > larguraInicial) { j=numMaxDeDivisoes; }
            else {
               System.out.print(larguras[indiceMenorBloco] + " ");
               tamanhoUtilizado += larguras[indiceMenorBloco];
               quantidadesRestantes[indiceMenorBloco]--;
               if(buscarMenorLarguraRestante() == -1) { i = numBlocosParaCortar; j=numMaxDeDivisoes;}
            }
         }
         System.out.println();
      }
   }

   private static int buscarMenorLarguraRestante() {   
      int indiceMenorLargura = -1;
      for(int i=0;i<larguras.length;i++)
         if(quantidadesRestantes[i] != 0)
            indiceMenorLargura = i;

      if(indiceMenorLargura == -1) { return -1; } // se todas quantidades obtidas
      else {
         for(int i=1;i<larguras.length;i++) 
            if(larguras[i] < larguras[indiceMenorLargura] && quantidadesRestantes[i] != 0)
               indiceMenorLargura = i;
         return indiceMenorLargura;
      }
   }
   
   
   private static void mostrarQuantidadesRestantes() { 
      int restantes = 0;
      for(int i=0;i<quantidadesRestantes.length;i++) 
         restantes+= quantidadesRestantes[i];
      System.out.println("Quantidade remanescente = " + restantes);
   }
}