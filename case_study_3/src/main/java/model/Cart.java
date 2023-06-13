package model;

import utils.CurrencyFormat;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    //đừng vô cái này em lạy anh nguyên

    private User user;
    List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public Cart(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    // số lượng 1 sản phẩm trong giỏ - khách sẽ mua
    public int getQuantityById(int id) {
        return getItemById(id).getQuantity();
    }

    public Item getItemById(int id) {
        for (Item i : items) {
            if (i.getProduct().getId()==id) {
                return i;
            }
        }
        return null;
    }

    private Item CheckItem(int id, String size) {
        for (Item i : items) {
            if (i.getProduct().getId() == id && i.size.equals(size)) {
                return i;
            }
        }
        return null;
    }

    // add 1 sản phẩm vào giỏ, nếu có rồi thì tăng số lượng
    public void addItem(Item t) {
        if (getItemById(t.getProduct().getId()) != null && CheckItem(t.getProduct().getId(), t.size) != null) {
            Item m = getItemById(t.getProduct().getId());
            m.setQuantity(m.getQuantity() + t.getQuantity());
        } else {
            items.add(t);
        }
    }
    //loại sản phẩm khỏi giỏ

    public void removeItem(int id) {
        if (getItemById(id) != null) {
            items.remove(getItemById(id));
        }
    }
    //tổng tiền của cả giỏ hàng – sẽ add vào bảng Order

    public double getTotalMoney() {
        double t = 0;
        for (Item i : items) {
            t += (i.getQuantity() * i.getProduct().getPrice());
        }
        return t;
    }

    public String getBillDetailPrice(double price) {
        String priceNew = CurrencyFormat.covertPriceToString(price);
        return priceNew;
    }
}
