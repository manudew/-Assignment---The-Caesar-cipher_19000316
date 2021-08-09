import scala.io.StdIn._

object enc {
   
    val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";

    //Encryption function
    val Enc = (c:Char,key:Int,a:String) =>
        a((a.indexOf(c.toUpper)+ key)%a.size)
    //Decryption function
    val Dec=(c:Char,key:Int,a:String)=> 
        if((a.indexOf(c.toUpper)- key)%a.size<0)
           a(a.size - math.abs((a.indexOf(c.toUpper)- key)%a.size))
        else
            a((a.indexOf(c.toUpper)- key)%a.size)
    //Function that maps given string with Encryption and Decryption functions
    val cipher = (fun:(Char,Int,String)=>Char,s:String,key:Int,a:String)=>
        s.map(fun(_,key,a))
    
    //Main function
    def main(args:Array[String]){

        //Enter a string
        println("Enter String:- ")
        val input = readLine()
        
        //Encryption of the given string
        val Ciphertext = cipher(Enc,input,3,alphabet)
        println("Encrypt:- "+Ciphertext)

        //Decryption of the given string
        val Plaintext = cipher(Dec,Ciphertext,3,alphabet)
        println("Decrypt:- "+Plaintext)
        
      
    }
}
