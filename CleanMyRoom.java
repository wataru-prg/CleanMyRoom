import java.io.*;
import java.util.*;


//mainクラス
class CleanMyRoom
{
  static int num1, num2;

  public static void main( String[] args ) throws IOException
  {
    System.out.println( "------------------------------------------" );
    System.out.println( " > 我が家を綺麗にしましょう" );

    Command com = new Command();

    //どこを綺麗にするか選ぶ
    com.chooseWhere();
    num1 = com.inputCommand_where( com.choiceNum );

    //掃除の内容を選ぶ
    com.chooseWhat();
    num2 = com.inputCommand_what( com.choiceNum );
  }
}


//コマンドを入力させるクラス
class Command
{
  static int num;
  static int choiceNum;

  //どこを綺麗にするか選ぶメソッド
  public static void chooseWhere() throws IOException
  {
    choose( "「場所」", "玄関", "洗面所", "キッチン", "リビング" );
  }

  //掃除の内容を選ぶメソッド
  public static void chooseWhat() throws IOException
  {
    CleanMyRoom cmr = new CleanMyRoom();

    switch( cmr.num1 )
    {
      case 1:
        choose( "「玄関」の掃除場所", "靴", "たたき", "洗濯機" );
        break;
      case 2:
        choose( "「洗面所」の掃除場所", "洗面台", "トイレ", "お風呂" );
        break;
      case 3:
        choose( "「キッチン」の掃除場所", "流し", "冷蔵庫", "棚", "廊下" );
        break;
      case 4:
        choose( "「リビング」の掃除場所", "クローゼット", "洋服", "机まわり", "ゴミ箱まわり", "床" );
        break;
      default:
        System.out.println( "!! 正しく実行されませんでした !!" );
        break;
    }
  }

  //場所選択でコマンドを入力させるメソッド
  public static int inputCommand_where( int inputChoiceNum ) throws IOException
  {
    try
    {
      Scanner sc = new Scanner( System.in );
      num = sc.nextInt();

      if( num > inputChoiceNum )
      {
        System.out.println( "!!「" + num + "」が入力されました !!" );
        System.out.println( "!! 正しい数値を入力してください !!" );
        chooseWhere();
        inputCommand_where( choiceNum );
      }
    }catch( Exception e ){
      System.out.println( "!! 数字以外が入力されました !!" );
      System.out.println( "!! 正しい数値を入力してください !!" );
      chooseWhere();
      inputCommand_where( choiceNum );
    }

    return( num );
  }

  //内容選択でコマンドを入力させるメソッド
  public static int inputCommand_what( int inputChoiceNum ) throws IOException
  {
    try
    {
      Scanner sc = new Scanner( System.in );
      num = sc.nextInt();

      if( num > inputChoiceNum )
      {
        System.out.println( "!!「" + num + "」が入力されました !!" );
        System.out.println( "!! 正しい数値を入力してください !!" );
        chooseWhat();
        inputCommand_what( choiceNum );
      }
    }catch( Exception e ){
      System.out.println( "!! 数字以外が入力されました !!" );
      System.out.println( "!! 正しい数値を入力してください !!" );
      chooseWhat();
      inputCommand_what( choiceNum );
    }

    return( num );
  }

  //選択肢から選ぶメソッド
  public static void choose( String... a )
  {
    System.out.println( "------------------------------------------" );
    System.out.println( " >" + a[0] + "を選んでください" );
    System.out.println( "------------------------------------------" );

    for( int i = 1; i < a.length; i++ )
    {
      System.out.println( i + "_" + a[i] );
    }

    choiceNum = a.length - 1;

    kaigyou();
  }

  //改行するメソッド
  public static void kaigyou()
  {
    System.out.println( " " );
  }
}
