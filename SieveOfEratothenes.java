int n = 1000000;
boolean[] tb = new boolean[n];
tb[0] = true;
for(int i = 1; i < n; i++) {
    if(!tb[i]) {
        for(int j = i+i; j < n; j += i) {
            tb[j] = true;
        }
    }
}