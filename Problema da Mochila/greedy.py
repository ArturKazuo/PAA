import time

inicio = time.time()

def mochila(values, weights, capacity):
    n = len(values)

    print(len(values))
    print(len(weights))
    
    # Calculate value-to-weight ratio for each item
    ratios = [(values[i] / weights[i], i) for i in range(n)]
    
    # Sort items by ratio in descending order
    ratios.sort(reverse=True, key=lambda x: x[0])
    
    max_value = 0
    knapsack = [0] * n
    
    for ratio, i in ratios:
        if weights[i] <= capacity:
            knapsack[i] = 1
            max_value += values[i]
            capacity -= weights[i]
    
    return max_value, knapsack

# Example usage
# values = [28,7,18,49,6]
# values = [28,7,18,49,6,10,12,27,25,37]
# values = [28,7,18,49,6,10,12,27,25,37,1,48,20,31,22,42,33,14,35,40,13,24,17,46,5,8,38,23,16,26]
# values = [28,7,18,49,6,10,12,27,25,37,1,48,20,31,22,42,33,14,35,40,13,24,17,46,5,8,38,23,16,26,47,30,41,29,39,45,4,44,11,36,2,15,50,32,3,19,9,21,43,34]
values = [28,7,18,49,6,10,12,27,25,37,1,48,20,31,22,42,33,14,35,40,13,24,17,46,5,8,38,23,16,26,47,30,41,29,39,45,4,44,11,36,2,15,50,32,3,19,9,21,43,34,49,7,22,46,17,38,45,10,11,23,48,44,1,37,3,19,20,28,26,40,25,27,2,6,30,13,16,5,18,21,15,8,47,50,24,31,14,32]

# weights = [14,19,3,18,6]
# weights = [14,19,3,18,6,12,10,2,16,1]
# weights = [14,19,3,18,6,12,10,2,16,1,5,13,20,4,15,11,9,7,8,17,2,19,6,14,8,17,3,5,12,15]
# weights = [14,19,3,18,6,12,10,2,16,1,5,13,20,4,15,11,9,7,8,17,2,19,6,14,8,17,3,5,12,15,4,7,10,1,18,11,13,16,9,20,19,8,5,2,15,10,4,1,13,7]
weights = [14,19,3,18,6,12,10,2,16,1,5,13,20,4,15,11,9,7,8,17,2,19,6,14,8,17,3,5,12,15,4,7,10,1,18,11,13,16,9,20,19,8,5,2,15,10,4,1,13,7,17,6,11,20,12,14,18,3,9,16,19,15,8,13,11,1,4,5,6,14,18,20,10,2,12,7,16,3,9,17,19,11,1,13,8,15,4,6,10,18,20]


# capacity = 30
# capacity = 50
# capacity = 80
# capacity = 120
capacity = 200

result_value, selected_items = mochila(values, weights, capacity)

print("Maximum value:", result_value)
print("Selected items:", selected_items)

fim = time.time()
print("tempo em microssegundos: ", (fim - inicio) * 1000 * 1000)