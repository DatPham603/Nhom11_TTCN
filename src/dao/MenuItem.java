package dao;

public class MenuItem {

    private Integer itemId;
    private String name;
    private String description;
    private float price;
    private String category;
    private byte available;

    public MenuItem() {
    }

    public MenuItem(Integer itemId, String name, String description, float price, String category, byte available) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
        this.available = available;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAvailable(byte available) {
        this.available = available;
    }

    public Integer getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public byte getAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return "MenuItem{" + "itemId=" + itemId + ", name=" + name + ", description=" + description + ", price=" + price + ", category=" + category + ", available=" + available + '}';
    }

}
