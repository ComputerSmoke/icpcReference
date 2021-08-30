private static ArrayList<Integer> KMPSearch(String key, String body) {
    ArrayList<Integer> ret = new ArrayList<Integer>();
    int m = key.length();
    int n = body.length();
    
    int lps[] = getLPSArray(key);
    int j = 0;
    int i = 0;
    while(i < n) {
        if(key.charAt(j) == body.charAt(i)) {
            j++;
            i++;
        }
        if(j == m) {
            ret.add(i - j);
            j = lps[j - 1];
        } else if(i < n && key.charAt(j) != body.charAt(i)) {
            if(j != 0) j = lps[j-1];
            else i++;
        }
    }
    return ret;
}

private static int[] getLPSArray(String key) {
    int m = key.length();
    int[] lps = new int[m];
    int len = 0;
    int i = 1;
    lps[0] = 0;
    
    while(i < m) {
        if(key.charAt(i) == key.charAt(len)) {
            len++;
            lps[i] = len;
            i++;
        } else {
            if(len != 0) len = lps[len-1];
            else {
                lps[i] = len;
                i++;
            }
        }
    }
    return lps;
}