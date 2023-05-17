package _22_CHAT;
public class Chat {
    public static void main(String[] args)
    {
        sendMessageWithDelay("megm", "Hi, there!", 0);
        sendMessageWithDelay("kathyo", "Hi, Meg!", 2000);
        sendMessageWithDelay("megm", "What are you doing?", 4000);
        sendMessageWithDelay("kathyo", "I'm sitting on my bed with my laptop. I'm doing my homework.", 8000);
        sendMessageWithDelay("megm", "What are you working on?", 10000);
        sendMessageWithDelay("kathyo", "I'm writing an essay for Spanish class. :)", 12000);
        sendMessageWithDelay("megm", "Where are you?", 14000);
        sendMessageWithDelay("kathyo", "I'm in a cafe with my friend Carmen. I'm having coffee, and she's talking on the phone outside.", 28000);
        sendMessageWithDelay("kathyo", "How is your family?", 16000);
        sendMessageWithDelay("megm", "They're all fine! My father's watching a baseball game with his friends. My mother is out shopping.", 36000);
        sendMessageWithDelay("kathyo", "Where's your brother?", 18000);
        sendMessageWithDelay("megm", "John's playing soccer in the park.", 20000);
        sendMessageWithDelay("kathyo", "Oh, wait. My phone is ringing. My mother's calling me. I have to go! Bye!", 48000);
        sendMessageWithDelay("megm", "OK! Bye!", 22000);
    }
    private static void sendMessageWithDelay(String sender, String message, int delay)
    {
        try
        {
            Thread.sleep(delay);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        String formattedMessage = String.format("<%s>: %s", sender, message);
        for (char c : formattedMessage.toCharArray())
        {
            System.out.print(c);
            try
            {
                Thread.sleep(50);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("");
    }
}
