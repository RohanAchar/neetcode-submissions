class Solution {
    //SOLVE AGAIN
    public int numUniqueEmails(String[] emails) {
        Set<String> uniqueEmails = new HashSet<>();
        
        for (String email : emails) {
            // Step 1: Split email into local name and domain name
            int splitIndex = email.indexOf('@');
            String local = email.substring(0, splitIndex);
            String domain = email.substring(splitIndex); // includes the '@'
            
            // Step 2: Process the local name
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < local.length(); i++) {
                char c = local.charAt(i);
                
                // If we hit a '+', ignore everything after it in the local name
                if (c == '+') {
                    break;
                }
                
                // If it's not a '.', append it
                if (c != '.') {
                    sb.append(c);
                }
            }
            
            // Step 3: Combine cleaned local name with the domain and add to Set
            String normalizedEmail = sb.toString() + domain;
            uniqueEmails.add(normalizedEmail);
        }
        
        // Step 4: Return the count of unique emails
        return uniqueEmails.size();
    }
}