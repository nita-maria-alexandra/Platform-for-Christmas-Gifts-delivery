package utils;

import enums.Category;

public final class Utils {

    private Utils() {
    }

    /**
     * Transforma un string intr-un enum
     * @param category categoria cadourilor
     * @return Enum
     */
    public static enums.Category stringToCategory(final String category) {
        return switch (category) {
            case "Board Games" -> Category.BOARD_GAMES;
            case "Books" -> Category.BOOKS;
            case "Clothes" -> Category.CLOTHES;
            case "Sweets" -> Category.SWEETS;
            case "Technology" -> Category.TECHNOLOGY;
            case "Toys" -> Category.TOYS;
            default -> null;
        };
    }
}
