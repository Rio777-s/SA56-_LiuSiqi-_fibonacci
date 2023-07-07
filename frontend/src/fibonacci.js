import React, { useState } from 'react';
import axios from 'axios';
import './fibonacci.css';

const FibonacciApp = () => {
  const [elements, setElements] = useState('');
  const [fibonacci, setFibonacci] = useState([]);
  const [sorted, setSorted] = useState([]);

  const handleSubmit = (e) => {
    e.preventDefault();
  
    const protocol = window.location.protocol;
    const hostname = window.location.hostname;
    const port = 8080; 
    const url = `${protocol}//${hostname}:${port}/fibonacci`;
  
    axios.post(url, { elements })
      .then(response => {
        setFibonacci(response.data.fibonacci);
        setSorted(response.data.sorted);
        console.log(url);
      })
      .catch(error => {
        console.error(error);
      });
  };

  return (
    <div class="container">
      <h1>Fibonacci Calculator</h1>
      <form onSubmit={handleSubmit}>
        <label class="sizef">
          Element:
          <input class="sizef rounded-pill" type="number" value={elements} onChange={(e) => setElements(e.target.value)} min={1} max={100} required/>
        </label>
        <button class="sizef btn btn-primary rounded-pill" type="submit">Compute Fibonacci</button>
      </form>

      <div>
        <div>
          <h3>Fibonacci Numbers:</h3>
          <div class="result-container">
            <ul>
              {fibonacci.map((number, index) => (
                <li key={index}>{number}</li>
              ))}
            </ul>
          </div>
        </div>

        <div>
          <h3>Sorted Numbers:</h3>
          <div class="result-container">
            <ul>
              {sorted.map((number, index) => (
                <li key={index}>{number}</li>
              ))}
            </ul>
          </div>
        </div>
      </div>

    </div>
  );
};

export default FibonacciApp;