import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react-swc'

export default defineConfig({
  root: './src/main/resources/static/',
  server: {
    proxy: {
      "/api": "http://localhost",
    },  
    port: 8092,
  },
  build: {
    rollupOptions: {
      input: {
        main: './src/main/resources/static/js/main.jsx',
      },
      output: [
        {
          dir: './src/main/resources/static/build',
          entryFileNames: 'bundle.js',
        },
      ]
    }
  },
  plugins: [react()],
})
