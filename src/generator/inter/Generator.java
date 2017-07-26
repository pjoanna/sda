package generator.inter;

/**
 * Created by RENT on 2017-07-24.
 */
public interface Generator<GeneratedType> {

     GeneratedType generate(); // typ generyczny

     public default void printTenElements(){
          for (int i = 0; i < 10; i++) {
               Object generated = this.generate();
               if (generated != null){
                    System.out.println(generated);

               }else {

               }
          }
     }

     public default void printEverySecondElement(){
          Object data = this.generate();
          for (int i = 0; i < 10; i++) {
               this.generate();
               System.out.println(this.generate());
          }

     }
}
