require 'find'

content_dir = File.join(Dir.pwd, 'CONTENT')

Find.find(content_dir) do |path|
  next unless path =~ /\.md$/

  content = File.read(path)
  
  if content =~ /layout: blank/
    puts "Updating layout in: #{path}"
    new_content = content.gsub(/layout: blank/, "layout: default")
    File.write(path, new_content)
  end
end
