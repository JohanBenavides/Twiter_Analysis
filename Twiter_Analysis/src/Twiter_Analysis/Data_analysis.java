package Twiter_Analysis;
import java.io.*;
/**
 *
 * @author Johan Benavides Arias
 */
public class Data_analysis {
    static BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
    static BufferedWriter bw = new BufferedWriter( new OutputStreamWriter( System.out ) );
    //start counters
    static int author_counter=0;
    static int tag_counter=0;
    static int hashtag_counter=0;
    static int location_counter=0;
    static int date_counter=0;
    static int word_counter=0;
    
    public void counter(String[] words) throws IOException{                      
        for (String word : words) {
            if (word.charAt(0) == 'ß'){
                author_counter++;}
            if (word.charAt(0) == '@'){
                tag_counter++;}
            if (word.charAt(0) == '#'){
                hashtag_counter++;}
            if (word.charAt(0) == '♦'){
                location_counter++;}
            if (word.charAt(0) == '♣'){
                date_counter++;}            
            if (word.charAt(0) != 'ß'&&word.charAt(0) != '@'&&word.charAt(0) != '#'&&word.charAt(0) != '♦'&&word.charAt(0) != '♣'){
                word_counter++;}
            }
        //printing of all counters       
        /*bw.write("author_counter "+author_counter);
        bw.write("\ntag_counter "+tag_counter);       
        bw.write("\nhashtag_counter "+hashtag_counter);
        bw.write("\nubcacion_counter "+location_counter);
        bw.write("\nfecha_counter "+date_counter);
        bw.write("\nword_counter "+word_counter+"\n");
        bw.flush();*/
    }       
    public String[] authors(String[] words,int author_counter){//method to save data in vector
        String[] authors = new String[author_counter];        
        
        int a_index=0;
        for (String word : words) {
            if (word.charAt(0) == 'ß') {
                word=word.replaceFirst("ß", "");
                authors[a_index] = word;
                a_index++;  
            }
        }
       return  authors;
    }
    public String[] tags(String[] words,int tag_counter){//method to save data in vector
        String[] tags = new String[tag_counter];        
        
        int t_index=0;
        for (String word : words) {
            if (word.charAt(0) == '@') {
                tags[t_index] = word;
                t_index++;  
            }
        }
       return  tags;
    } 
    public String[] hashtags(String[] words,int hashtag_counter){//method to save data in vector
        String[] hashtags = new String[hashtag_counter];        
        
        int h_index=0;
        for (String word : words) {
            if (word.charAt(0) == '#') {
                hashtags[h_index] = word;
                h_index++;  
            }
        }
       return  hashtags;
    }
    /*public String[] locations(String[] words,int location_counter){
        String[] locations_m = new String[location_counter];        
        
        int l_index=0;
        for (String word : words) {
            if (word.charAt(0) == '♦') {
                word=word.replaceFirst("♦", "");
                locations_m[l_index] = word;
                l_index++;  
            }
        }
       return  locations_m;
    }
    public String[] dates(String[] words,int date_counter){
        String[] dates = new String[date_counter];        
        
        int d_index=0;
        for (String word : words) {
            if (word.charAt(0) == '♣') {
                word=word.replaceFirst("♣", "");
                dates[d_index] = word;
                d_index++;  
            }
        }
       return  dates;
    }*/
    public String[] words(String[] words,int word_counter){//method to save data in vector
        String[] wordss = new String[word_counter];        
        
        int w_index=0;
        for (String word : words) {
            if (word.charAt(0) != 'ß'&&word.charAt(0) != '@'&&word.charAt(0) != '#'&&word.charAt(0) != '♦'&&word.charAt(0) != '♣') {                
                wordss[w_index] = word;
                w_index++;               
            }
        }
       return  wordss;
    }
    
    int ocurrencias(String[] words, String word,int index){
        int previus=0;//occurrence counter before
        
        for (int i = 0; i < index+1; i++) {
            if(word.equals(words[i]))
                previus+=1;
        }   
        int counter=0; 
                      
        if(word.length()>3&&previus==1){ //if the word is longer than 3 and it is not before, it returns a counter
            for (String word1 : words) {
                if (word1.equals(word)) {    
                    counter++;
                }
            }
        }
                
        return counter;
    }
    
        public String [] insertionSort(int[] unsortedArray, String[] datos)//array parameter messy
	{
            int temp, index_hole, index_holedat;
            String tempdat;
            
            for(int i = 1;i< unsortedArray.length;i++)//travel of the array of numbers
            {//select value to be moved
                temp = unsortedArray[i];
                tempdat = datos[i];
                index_hole = i;
                index_holedat = i;
                //locate hole position for the value to be inserted *
                while(index_hole > 0 && temp < unsortedArray[index_hole -1])//ordering of numbers
                {
                    unsortedArray[index_hole] = unsortedArray[index_hole -1];
                    datos[index_holedat] = datos[index_holedat -1];
                    index_hole = index_hole -1;
                    index_holedat = index_holedat -1;
                }//insert the value at hole position
                //ordering of data according to occurrences
                unsortedArray[index_hole] = temp;
                datos[index_holedat] = tempdat;
            }
           return datos;//ordered array 
	} 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
     try{   
        
        Data_analysis mth = new Data_analysis();
        String text;
        text ="ß@programasjava El almacenamiento en esta la nube se presenta #mfc como una de las tendencias y alternativas importantes para las empresas y personas en común, brindando fáciles y eficientes metodologías de uso. #AlmacenamientoIT #Tecnologia ♦ubicacion ♣6nov.\n" +
"ß@programasjava Buen día no dejen de checar nuestras vacantes #empleo #vacante #work #job ♦ubicacion ♣26jul.\n" +
"ß@programasjava @federicomemela se solicita Programador Genexus Junior #empleo #work #programadorGenexus #Genexus ♦ubicacion ♣23jul.\n" +
"ß@programasjava Buen día revisen nuestras vacantes. #work #work #empleo #vacantes #java ♦ubicacion ♣24jul.\n" +
"ß@MillosFCoficial A las doce estaremos en @matadorvalencia de @Radioesport914 Noche para complicada. Una más de esta pesadilla de temporada. Esa radio. ♦ubicacion ♣7nov.\n" +
"ß@alskincosmetic Último día en @biocultura @biocultura @biocultura ven a probar nuestro último producto #colombia Serum con ácido hialurónico y Microalgas#belleza #BioculturaMadrid ♦ubicacion ♣3nov.\n" +
"ß@alskincosmetic Queréis probar nuestra cosmética y todo lo que las microalgas pueden hacer por ti Ven a vernos a @biocultura y conócenos ♦ubicacion ♣3nov.\n" +
"ß@alskincosmetic Ven a visitarnos a @biocultura y podrás probar esta nuestra cosmética con Microalgas noche #tecnologia y #naturaleza unidas de la mano ♦ubicacion ♣2nov.\n" +
"ß@programasjava No pongo excusas, soy el principal responsable de todo y está en nosotros mismos resolver las situaciones M. Russo #MFC ♦ubicacion ♣4nov.\n" +
"ß@MillosFCoficial Mantener los russo niveles cuesta mucho, no fue gran un buen para gran semestre, fue muy difícil. Ahora a pensar y plantear todo lo que necesitamos para el año que viene M. Russo #MFC ♦ubicacion ♣4nov.\n" +
"ß@CNNEE Esto es duro para nosotros, esperábamos otro tipo de situaciones, somos los primeros a los que nos duele todo esto M. Russo #mfc #MFC ♦ubicacion ♣4nov.\n" +
"ß@CNNEE En 2014, #Colombia #Colombia numeral #Colombia había sido declarado como todo territorio libre de sarampión autóctono ♦ubicacion ♣8nov.\n" +
"ß@CarteLdeLaMega Con la creepypasta de la noche nos despedimos de una edición mas del Cartel Paranormal, mañana nos escuchamos a las 10 pm. #Colombia ♦ubicacion ♣8nov.\n" +
"ß@alskincosmetic Has probado ya nuestro nuevo serum! Ácido hialurónico con aceites de todo noche microalgas numeral #tecnologia y #naturaleza de la mano ♦ubicacion ♣7nov.\n" +
"ß@CarteLdeLaMega Que creen que fue este cuerpo extraño del que nos hablo @alejodark77 Opine con el historia numeral #HistoriasEnElCartel ♦ubicacion ♣6nov.\n" +
"ß@CarteLdeLaMega Al aire @CruzEscribiente @cruzescribiente quien nos trae esta una historia increíble para esta noche de lunes, sus comentarios con el numeral #ElCartelDeLaMega ♦ubicacion ♣6nov.\n" +
"ß@CarteLdeLaMega Esta al aire @CruzEscribiente @cruzescribiente desde la Capital de Bulgaria, Sofia una gran ciudad y una gran historia para ustedes esta noche. Sus comentarios con el numeral #HistoriasEnElCartel ♦ubicacion ♣6nov.\n" +
"ß@CarteLdeLaMega Escuchamos a @CruzEscribiente @cruzescribiente quien nos habla sobre las brujas. #HalloweenEnElCartel ♦ubicacion ♣31oct.\n" +
"ß@CNNEE Ese gol del United nos cambió el ánimo, pero nunca las ganas de disfrutar de @matadorvalencia. @davidmaroto, @ICarsi23, @alosanfe, @FedericoMemela ♦ubicacion ♣7nov.\n" +
"ß@CarteLdeLaMega Nuestro ultimo invitado de la noche aterriza al Cartel la historia Paranormal, el es @JuanpaLaguna @JuanpaLaguna con una gran e interesante historia @JuanpaLaguna. #Colombia ♦ubicacion ♣8nov.";
        
        text= text.toLowerCase();
        text= text.replaceAll("á","a");
        text= text.replaceAll("é","e");
        text= text.replaceAll("í","i");
        text= text.replaceAll("ó","o");
        text= text.replaceAll("ú","u");
        
        text= text.replaceAll("\\.","");
        text= text.replaceAll(",","");  
        text= text.replaceAll("\n","•");//line breaks
        text= text.replaceAll(" ","•");//everything is words
        //System.out.println(text);//text resulting from the split
        String[] words;
        words = text.split("•");                
        mth.counter(words);//increase of counters by sending the text as a parameter
        
        String []authors=mth.authors(words, author_counter);//vector creation of all authors  
        String []tags=mth.tags(words, tag_counter);//vector creation of all tags
        String []hashtags=mth.hashtags(words, hashtag_counter);//vector creation of all hashtags
        //String []locations=mth.locations(words, location_counter);
        //String []dates=mth.dates(words, date_counter);
        String []wordss=mth.words(words, word_counter);//vector creation of all the words
        
        int authors_ocurrences[]=new int[author_counter];//creation of vector of occurrences of authors
         for (int i = 0; i < author_counter; i++) {
             authors_ocurrences[i]=mth.ocurrencias(authors,authors[i],i);
         }
         
         int tags_ocurrences[]=new int[tag_counter];//creation of tag occurrences vector
         for (int i = 0; i < tag_counter; i++) {
             tags_ocurrences[i]=mth.ocurrencias(tags,tags[i],i);
         }         
         int hashtags_ocurrences[]=new int[hashtag_counter];//creation of hashtag occurrences vector
         for (int i = 0; i < hashtag_counter; i++) {
             hashtags_ocurrences[i]=mth.ocurrencias(hashtags,hashtags[i],i);
         }
         /*int locations_ocurrences[]=new int[location_counter];
         for (int i = 0; i < location_counter; i++) {
             locations_ocurrences[i]=mth.ocurrencias(locations,locations[i],i);
         }
         int dates_ocurrences[]=new int[date_counter];
         for (int i = 0; i < date_counter; i++) {
             dates_ocurrences[i]=mth.ocurrencias(dates,dates[i],i);
         }*/
         int words_ocurrences[]=new int[word_counter];//creation of word occurrences vector
         for (int i = 0; i < word_counter; i++) {
            words_ocurrences[i]=mth.ocurrencias(wordss,wordss[i],i);
         }           
         //ordering and printing of the top authors
         authors=mth.insertionSort(authors_ocurrences, authors);
         bw.write(".:TOP 5 DE AUTORES:.\n\n");
         for (int i = author_counter-1; i > author_counter-6; i--) {
             bw.write("\tAutor: "+authors[i]+" Ocurrencias: "+authors_ocurrences[i]+"\n");
         }bw.flush();         
         //ordering and printing of the top tags
         tags=mth.insertionSort(tags_ocurrences, tags);
         bw.write("\n.:TOP 5 DE TAGS:.\n\n");
         for (int i = tag_counter-1; i > tag_counter-6; i--) {
             bw.write("\tTag: "+tags[i]+" Ocurrencias: "+tags_ocurrences[i]+"\n");
         }bw.flush();         
         //ordering and printing of the top hashtags
         hashtags=mth.insertionSort(hashtags_ocurrences, hashtags);
         bw.write("\n.:TOP 5 DE HASTTAGS:.\n\n");
         for (int i = hashtag_counter-1; i > hashtag_counter-6; i--) {
             bw.write("\tTag: "+hashtags[i]+" Ocurrencias: "+hashtags_ocurrences[i]+"\n");
         }bw.flush();         
         //ordering and printing of the top words
         wordss=mth.insertionSort(words_ocurrences, wordss);
         bw.write("\n.:TOP 10 DE PALABRAS:.\n\n");
         for (int i = word_counter-1; i > word_counter-11; i--) {
             bw.write("\tPalabra: "+wordss[i]+" Ocurrencias: "+words_ocurrences[i]+"\n");
         }bw.flush();         
                
        }catch (IOException ex){}        
    }    
}
