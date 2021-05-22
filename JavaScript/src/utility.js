export function bubbleSortByPrice(array) {
    let result = [...array];
    for (var i = 0; i < result.length; i++) {
        for (var j = 0; j < (result.length - i - 1); j++) {
            if (result[j].price > result[j + 1].price) {
                //swap element
                [result[j], result[j + 1]] = [result[j + 1], result[j]];
            }
        }
    }
    return result;
}