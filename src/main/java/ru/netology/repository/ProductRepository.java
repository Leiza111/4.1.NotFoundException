package ru.netology.repository;

import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;

public class ProductRepository {
    private Product[] items = new Product[0];

    //сохранение продуктов
    public void save(Product product) {
        // создаем новый массив на единицу больше
        int length = items.length + 1;
        Product[] tmp = new Product[length];
        //копирование поэлементно
        System.arraycopy(items, 0, tmp, 0, items.length);
        //кладем последним наш элемент
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = product;
        items = tmp;
    }
    // получение всех сохраненных продуктов
    public Product[] findAll() {
        return items;
    }


    public Product findById(int id) {
        for (Product item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
    //удаление по id
    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException(
                    "Element with id: " + id + " not found");
        }

        int length = items.length-1;
        Product[] tmp = new Product[length];
        int index = 0;
        for (Product product: items) {
            if (product.getId() !=id) {
                tmp[index] = product;
                index++;
            }
        }
        //меняеи наши элементы
        items = tmp;
    }

}