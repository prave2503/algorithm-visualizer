package com.algorithm.visualizer.service;

import com.algorithm.visualizer.model.Algorithm;
import com.algorithm.visualizer.repository.AlgorithmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;
import java.util.List;

@Service
public class AlgorithmService {
    
    @Autowired
    private AlgorithmRepository algorithmRepository;
    
    public List<Algorithm> getAllAlgorithms() {
        return algorithmRepository.findAll();
    }
    
    public Algorithm getAlgorithmById(Long id) {
        return algorithmRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Algorithm not found"));
    }
    
    @PostConstruct
    public void seedAlgorithms() {
        // Clear existing
        algorithmRepository.deleteAll();
        
        // 1. Bubble Sort
        Algorithm bubbleSort = new Algorithm();
        bubbleSort.setName("Bubble Sort");
        bubbleSort.setCategory("Sorting");
        bubbleSort.setComplexity("O(n²)");
        bubbleSort.setDescription("Bubble sort repeatedly steps through the list, compares adjacent elements and swaps them if they're in the wrong order.");
        bubbleSort.setCodeTemplate("function bubbleSort(arr) {\n    let n = arr.length;\n    for(let i = 0; i < n-1; i++) {\n        for(let j = 0; j < n-i-1; j++) {\n            if(arr[j] > arr[j+1]) {\n                [arr[j], arr[j+1]] = [arr[j+1], arr[j]];\n            }\n        }\n    }\n    return arr;\n}");
        
        // 2. Binary Search
        Algorithm binarySearch = new Algorithm();
        binarySearch.setName("Binary Search");
        binarySearch.setCategory("Searching");
        binarySearch.setComplexity("O(log n)");
        binarySearch.setDescription("Binary search finds the position of a target value within a sorted array.");
        binarySearch.setCodeTemplate("function binarySearch(arr, target) {\n    let left = 0;\n    let right = arr.length - 1;\n    while(left <= right) {\n        let mid = Math.floor((left + right) / 2);\n        if(arr[mid] === target) return mid;\n        if(arr[mid] < target) left = mid + 1;\n        else right = mid - 1;\n    }\n    return -1;\n}");
        
        // 3. Quick Sort
        Algorithm quickSort = new Algorithm();
        quickSort.setName("Quick Sort");
        quickSort.setCategory("Sorting");
        quickSort.setComplexity("O(n log n)");
        quickSort.setDescription("Quick sort picks a pivot element and partitions the array around it.");
        quickSort.setCodeTemplate("function quickSort(arr) {\n    if(arr.length <= 1) return arr;\n    const pivot = arr[arr.length-1];\n    const left = [];\n    const right = [];\n    for(let i = 0; i < arr.length-1; i++) {\n        if(arr[i] < pivot) left.push(arr[i]);\n        else right.push(arr[i]);\n    }\n    return [...quickSort(left), pivot, ...quickSort(right)];\n}");
        
        // 4. Merge Sort
        Algorithm mergeSort = new Algorithm();
        mergeSort.setName("Merge Sort");
        mergeSort.setCategory("Sorting");
        mergeSort.setComplexity("O(n log n)");
        mergeSort.setDescription("Merge sort divides the array into halves, recursively sorts them, then merges.");
        mergeSort.setCodeTemplate("function mergeSort(arr) {\n    if(arr.length <= 1) return arr;\n    const mid = Math.floor(arr.length / 2);\n    const left = mergeSort(arr.slice(0, mid));\n    const right = mergeSort(arr.slice(mid));\n    return merge(left, right);\n}\n\nfunction merge(left, right) {\n    const result = [];\n    while(left.length && right.length) {\n        if(left[0] < right[0]) result.push(left.shift());\n        else result.push(right.shift());\n    }\n    return [...result, ...left, ...right];\n}");
        
        // 5. Insertion Sort
        Algorithm insertionSort = new Algorithm();
        insertionSort.setName("Insertion Sort");
        insertionSort.setCategory("Sorting");
        insertionSort.setComplexity("O(n²)");
        insertionSort.setDescription("Insertion sort builds the final sorted array one element at a time.");
        insertionSort.setCodeTemplate("function insertionSort(arr) {\n    for(let i = 1; i < arr.length; i++) {\n        let current = arr[i];\n        let j = i - 1;\n        while(j >= 0 && arr[j] > current) {\n            arr[j + 1] = arr[j];\n            j--;\n        }\n        arr[j + 1] = current;\n    }\n    return arr;\n}");
        
        algorithmRepository.save(bubbleSort);
        algorithmRepository.save(binarySearch);
        algorithmRepository.save(quickSort);
        algorithmRepository.save(mergeSort);
        algorithmRepository.save(insertionSort);
        
        System.out.println("✅ Added 5 algorithms to database!");
        System.out.println("📊 Algorithms: Bubble Sort, Binary Search, Quick Sort, Merge Sort, Insertion Sort");
    }
}
