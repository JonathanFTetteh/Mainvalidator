import java.util.NoSuchElementException;

public class Validator {

    /**
     * Validates e-mail adress. Checks if this not null or empty
     * Checks if the e-mail adress has correct chars sequence.
     *
     * @param email String - valid e-mail adress as a text.
     * @return boolean - true if e-mail adress valid, false if not.
     */


    public static boolean isValid(String email){
        if (email == null || email.isBlank()) {
            throw new NullPointerException("ERROR: adress cannot be null or empty");
        }

        String cleanMail = email.trim();

       if (!containsMailSign(email)){
           throw new NoSuchElementException("ERROR: E-Mail adress does not contain '@' Sign! ");
       }


        return true;

    }

    /**
     * Validates whether the String contains "@" sign.
     * Verify that @ sign count == 1.
     * @param email String - valid e-mail address as a text.
     * @return boolean - true if e-mail adress valid "@! sign, false if not.
     */
    private static boolean containsMailSign(String email){
        int count = 0;
        // email.length() - email.replace("@","").length();
        for (int i = 0; i < email.length(); i++){
            if (email.charAt(i) == '@') count++;
        }
        return count == 1;
    }

    /**
     * Validates whether the end of the given email address comntains "."
     * and at least 2 chars.
     * @param email String - valid e-mail adress as a text.
     * @return boolean - true if e-mail adress valid "." and
     * atleast 2 chars at the end, false if not
     */
    private static boolean isRootDomainValid(String email){
        String[] splittEmail = email.split("@");
        if (splittEmail != null && splittEmail.length == 2){

                String domainPart = splittEmail[1];
           if (domainPart.charAt(0) != '.'
               && domainPart.charAt(domainPart.length()-1)!= '.'){

            //TODO: validate duplicates of ".". I.E. ".."
            String[] domainParts = splittEmail[1].split(".");
            if (domainParts != null && domainParts.length > 1) {

                String rootDomain = domainParts[domainParts.length - 1];
                return rootDomain.length() > 1;

            }
            }
                    }
        return false;
    }
}
