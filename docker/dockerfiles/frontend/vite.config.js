import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

export default defineConfig({
  root: './static/',
  server: {
    proxy: {
      "/api": "http://localhost:8091",
//      "/api": "http://localhost:8091",
    },
  },
  build: {
    rollupOptions: {
      input: {
        main: './static/js/main.jsx',
      },
      output: [
        {
          dir: './static/build',
          entryFileNames: 'bundle.js',
        },
      ]
    }
  },
  plugins: [react()],
})
