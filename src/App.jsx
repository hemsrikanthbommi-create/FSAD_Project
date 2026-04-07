import { useEffect, useState } from 'react'
import './App.css'
import { fun1 as Fun1, fun2 as Fun2 } from './component/Page1'

function App() {
  const [message, setMessage] = useState('Loading backend...')

  useEffect(() => {
    fetch('/api/hello')
      .then((response) => response.json())
      .then((data) => setMessage(data.message))
      .catch(() => setMessage('Unable to reach Spring Boot backend.'))
  }, [])

  return (
    <div className="App">
      <header>
        <h1>React + Spring Boot Integration</h1>
        <p>{message}</p>
      </header>
      <main>
        <Fun1 />
        <Fun2 />
      </main>
    </div>
  )
}

export default App
