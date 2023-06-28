package main.java;

import java.util.List;
public class Order {
//        private int guest;
//        private String[] order;
//        private int check;
//        private String[] menu;
//        private int price;
//
//    /*public Ordering(int table, int guest, String[] order){
//        this.table = table;
//        this.guest = guest;
//        this.order = new String[]{"order"};
//    }*/
//
//        public static int getTable () {
//        int number;
//        boolean isUsing;
//
//        return 0;
//    }
//        public int getGuest () {
//        return this.guest;
//    }
//        public String[] getorder () {
//        return this.order;
//    }
//

    List<Menu> menuList;
    int guestNum;
    int tableNum;
    boolean isPaid;
    public Order(List<Menu> menuList, int guestNum, int tableNum, boolean isPaid) {
        this.menuList = menuList;
        this.guestNum = guestNum;
        this.tableNum = tableNum;
        this.isPaid = isPaid;
    }

    public int getTotalAmount() {
        int amount = 0;
        for(int i = 0; i < menuList.size(); i++) {
            amount = amount + menuList.get(i).price;
        }
        return amount;
    }

    @Override
    public String toString() {
        String str = "";
        str = str + "注文メニュー:" + "\n";
        for (int i = 0; i < menuList.size(); i++){
            str = str + menuList.get(i).name + "\n";
        }
        str = str + "卓番:" + tableNum + "\n"
                + "人数:" + guestNum + "\n"
                + "合計金額:" + this.getTotalAmount() + "\n";

        return str;
    }
}

