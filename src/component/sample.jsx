import React, { useState } from 'react'
import axios from 'axios'

function AddPost() {
  const [t, setT] = useState('')
  const [b, setB] = useState('')
  const [msg, setMsg] = useState('')

  const h = (e) => {
    e.preventDefault()
    axios.post('https://jsonplaceholder.typicode.com/posts', {
      title: t,
      body: b
    }).then(res => {
      setMsg('Post added successfully!')
      console.log(res.data)
    }).catch(() => setMsg('Error adding post'))
  }

  return (
    <div>
      <h2>Add Post</h2>
      <form onSubmit={h}>
        <input type="text" value={t} onChange={e => setT(e.target.value)} placeholder="Title" /><br/>
        <textarea value={b} onChange={e => setB(e.target.value)} placeholder="Body"></textarea><br/>
        <button type="submit">Submit</button>
      </form>
      <p>{msg}</p>
    </div>
  )
}

export default AddPost