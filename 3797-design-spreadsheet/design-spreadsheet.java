class Spreadsheet {
    HashMap<String,Integer> mp;

    public Spreadsheet(int rows) {
        mp = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        mp.put(cell,value);
    }
    
    public void resetCell(String cell) {
        mp.put(cell,0);
    }
    
    public int getValue(String formula) {
        if (formula.startsWith("=")) {
            formula = formula.substring(1);
        }
        String[] str = formula.split("\\+");
        int x = isAlphabet(str[0].charAt(0))?mp.getOrDefault(str[0],0):Integer.parseInt(str[0]);
        int y = isAlphabet(str[1].charAt(0))?mp.getOrDefault(str[1],0):Integer.parseInt(str[1]);

        return x+y;
    }

    private boolean isAlphabet(char ch){
        return Character.isUpperCase(ch);
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */